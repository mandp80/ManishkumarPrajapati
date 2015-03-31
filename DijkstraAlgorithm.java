/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import com.barclays.baggagesys.algorithm.bean.Edge;
import com.barclays.baggagesys.algorithm.bean.Graph;
import com.barclays.baggagesys.algorithm.bean.Node;
import com.barclays.baggagesys.exception.PathFinderException;

// TODO: Auto-generated Javadoc
/**
 * The Class DijkstraAlgorithm.
 */
public class DijkstraAlgorithm implements GraphAlogrithm {


	/** The edges. */
	private final List<Edge> edges;

	/** The settled nodes. */
	private Set<Node> settledNodes;

	/** The predecessors. */
	private ConcurrentMap<Node, Node> predecessors;

	/**
	 * Instantiates a new dijkstra algorithm.
	 *
	 * @param graph
	 *            the graph
	 */
	public DijkstraAlgorithm(final Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.edges = new ArrayList<Edge>(graph.getEdges());
		
	}

	/**
	 * Execute.
	 *
	 * @param source
	 *            the source
	 */
	public void execute(final Node source) {
		
		this.predecessors = new ConcurrentHashMap<Node, Node>();
		this.settledNodes = new CopyOnWriteArraySet<Node>();
		Queue<Node> unSettledNodes = new PriorityQueue<Node>();
		
		source.setDistance(0);
		unSettledNodes.add(source);

		while (!unSettledNodes.isEmpty()) {
			Node node = unSettledNodes.poll();
			settledNodes.add(node);
			final List<Node> adjacentNodes = getNeighbors(node);
			
			for (Node adjNode : adjacentNodes) {
				adjNode.setDistance(Integer.MAX_VALUE);
				int newDistance = node.getDistance()
						+ getDistance(node, adjNode);
				if (adjNode.getDistance() > newDistance) {
					adjNode.setDistance(newDistance);
					unSettledNodes.add(adjNode);
					predecessors.putIfAbsent(adjNode, node);
				}
			}
		}

	}

	/**
	 * Gets the optimal path. This method returns the path from the source to
	 * the selected target and NULL if no path exists
	 *
	 * @param target
	 *            the target
	 * @return the path
	 */
	public List<Node> getOptimalPath(final Node target) {
		final List<Node> path = new LinkedList<Node>();
		Node step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			throw new PathFinderException("The Graph is not correct");
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	/**
	 * Gets the optimal distances.
	 *
	 * @param target
	 *            the target
	 * @return the optimal distances
	 */
	public Integer getOptimalDistances(final Node target) {

		return target.getDistance();
	}

	/**
	 * Gets the distance.
	 *
	 * @param node
	 *            the node
	 * @param target
	 *            the target
	 * @return the distance
	 */
	private int getDistance(final Node node, final Node target) {
		for (final Edge edge : edges) {
			if (edge.getSource().equals(node)
					&& edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new PathFinderException("Should not happen");
	}

	/**
	 * Gets the neighbors.
	 *
	 * @param node
	 *            the node
	 * @return the neighbors
	 */
	private List<Node> getNeighbors(final Node node) {
		final List<Node> neighbors = new ArrayList<Node>();
		for (final Edge edge : edges) {
			if (edge.getSource().equals(node)
					&& !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	/**
	 * Checks if is settled.
	 *
	 * @param vertex
	 *            the vertex
	 * @return true, if is settled
	 */
	private boolean isSettled(final Node vertex) {
		return settledNodes.contains(vertex);
	}

}
