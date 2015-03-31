/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.controller;

import static com.barclays.baggagesys.constant.BaggageSystemConstants.FLIGHTID_ARRIVAL;
import static com.barclays.baggagesys.constant.BaggageSystemConstants.NODE_BAGGAGE_CLAIM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.barclays.baggagesys.algorithm.GraphAlogrithm;
import com.barclays.baggagesys.algorithm.bean.Edge;
import com.barclays.baggagesys.algorithm.bean.Graph;
import com.barclays.baggagesys.algorithm.bean.Node;
import com.barclays.baggagesys.controller.bean.Bag;
import com.barclays.baggagesys.controller.bean.ConveyorSystem;
import com.barclays.baggagesys.controller.bean.Departure;
import com.barclays.baggagesys.controller.bean.PathFinderInput;
import com.barclays.baggagesys.controller.bean.PathFinderOutput;
import com.barclays.baggagesys.factory.GraphAlgorithmFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PathFinder.
 */
public class PathFinder implements PathFinderIntf{

	/** The conveyor system. */
	private List<ConveyorSystem> conveyorSystemInputs;

	/** The departures. */
	private List<Departure> departures;

	/** The bags. */
	private List<Bag> bags;

	/** The graph algorithm. */
	private GraphAlogrithm graphAlgorithm;

	/** The graph algorithm str. */
	private String graphAlgorithmStr;

	/** The path finder outputs. */
	private List<PathFinderOutput> pathFinderOutputs;

	/**
	 * Instantiates a new path finder.
	 *
	 * @param pathFinderInput
	 *            the path finder input
	 */
	public PathFinder(final PathFinderInput pathFinderInput) {
		super();
		if (pathFinderInput != null) {
			this.conveyorSystemInputs = pathFinderInput
					.getConveyorSystemInputs();
			this.departures = pathFinderInput.getDepartures();
			this.bags = pathFinderInput.getBags();
			this.graphAlgorithmStr = pathFinderInput.getGraphAlgorithmStr();

			final Graph conveyorSystemGraph = constructConveyorSystem(this.conveyorSystemInputs);
			this.graphAlgorithm = GraphAlgorithmFactory.getGraphAlgorithm(
					conveyorSystemGraph, this.graphAlgorithmStr);
			this.pathFinderOutputs = new CopyOnWriteArrayList<PathFinderOutput>();
		}
	}

	/**
	 * Find optimal path.
	 *
	 * @return the list
	 */
	public List<PathFinderOutput> findOptimalPath() {
		Node sourceNode = null;
		Node targetNode = null;
		
		List<Node> optimalPath = Collections.emptyList();
		Integer optimalDistance;

		String bagFlightId = null;
		String departureFlightId = null;
		PathFinderOutput pathFinderOutput = null;
		for (final Bag bag : bags) {
			sourceNode = bag.getEntryPointNode();
			bagFlightId = bag.getFlightId();
			if (bagFlightId != null
					&& FLIGHTID_ARRIVAL.equalsIgnoreCase(bagFlightId)) {
				Node baggageClaimNode = new Node(NODE_BAGGAGE_CLAIM);
				for(ConveyorSystem conveyorSystemInput : conveyorSystemInputs){
					if(baggageClaimNode.equals(conveyorSystemInput.getNode2())){
						targetNode = conveyorSystemInput.getNode2();
						break;
					}
				}
			}
			for (final Departure departure : departures) {
				departureFlightId = departure.getFlightId();
				if (departureFlightId != null
						&& departureFlightId.equals(bagFlightId)) {
					targetNode = departure.getFlightGateNode();
					break;
				}

			}
			graphAlgorithm.execute(sourceNode);
			optimalPath = graphAlgorithm.getOptimalPath(targetNode);
			optimalDistance = graphAlgorithm.getOptimalDistances(targetNode);

			pathFinderOutput = new PathFinderOutput(bag.getBagNumber(),
					optimalPath, optimalDistance);
			pathFinderOutputs.add(pathFinderOutput);
		}

		return pathFinderOutputs;

	}

	/**
	 * Construct conveyor system.
	 *
	 * @param conveyorSystemInputs
	 *            the conveyor system inputs
	 * @return the graph
	 */
	private Graph constructConveyorSystem(
			final List<ConveyorSystem> conveyorSystemInputs) {

		final List<Node> nodes = new ArrayList<Node>();
		final List<Edge> edges = new ArrayList<Edge>();

		Node node1, node2;
		Edge edgeForward, edgeBackward;
		int travelTime;
		for (final ConveyorSystem conveyorSystemInput : conveyorSystemInputs) {
			node1 = conveyorSystemInput.getNode1();
			node2 = conveyorSystemInput.getNode2();
			travelTime = conveyorSystemInput.getTravelTime();

			if (nodes != null && !nodes.contains(node1)) {
				nodes.add(node1);
			}
			if (nodes != null && !nodes.contains(node2)) {
				nodes.add(node2);
			}

			edgeForward = new Edge(node1.getId() + node2.getId(), node1, node2,
					travelTime);
			edges.add(edgeForward);

			edgeBackward = new Edge(node2.getId() + node1.getId(), node2,
					node1, travelTime);
			edges.add(edgeBackward);
		}
		return new Graph(nodes, edges);

	}
}
