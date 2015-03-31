/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.test;

import static com.barclays.baggagesys.constant.BaggageSystemConstants.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import com.barclays.baggagesys.algorithm.bean.Node;
import com.barclays.baggagesys.controller.PathFinder;
import com.barclays.baggagesys.controller.PathFinderIntf;
import com.barclays.baggagesys.controller.bean.Bag;
import com.barclays.baggagesys.controller.bean.ConveyorSystem;
import com.barclays.baggagesys.controller.bean.Departure;
import com.barclays.baggagesys.controller.bean.PathFinderInput;
import com.barclays.baggagesys.controller.bean.PathFinderOutput;
import com.barclays.baggagesys.exception.PathFinderException;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDijkstraAlgorithm.
 */
public class BaggagePathFindingTest {
	
	/** The concourse a ticketing node. */
	private Node concourseATicketingNode;

	/** The baggage claim node. */
	private Node baggageClaimNode;

	/** The a10 node. */
	private Node a1Node, a2Node, a3Node, a4Node, a5Node, a6Node, a7Node,
			a8Node, a9Node, a10Node;

	/**
	 * Inits the Test Node values.
	 */
	@Before
	public void init() {

		concourseATicketingNode = new Node(NODE_CONCOURSE_A_TICKETING);
		baggageClaimNode = new Node(NODE_BAGGAGE_CLAIM);
		a1Node = new Node(NODE_A1);
		a2Node = new Node(NODE_A2);
		a3Node = new Node(NODE_A3);
		a4Node = new Node(NODE_A4);
		a5Node = new Node(NODE_A5);
		a6Node = new Node(NODE_A6);
		a7Node = new Node(NODE_A7);
		a8Node = new Node(NODE_A8);
		a9Node = new Node(NODE_A9);
		a10Node = new Node(NODE_A10);
	}

	/**
	 * Test optimal routing.
	 */
	@Test
	public void testOptimalRouting() {

		/* Section: Conveyor System */
		List<ConveyorSystem> conveyorSystemInputs = new ArrayList<ConveyorSystem>();
		conveyorSystemInputs.add(new ConveyorSystem(
				concourseATicketingNode, a5Node, 5));
		conveyorSystemInputs.add(new ConveyorSystem(a5Node,
				baggageClaimNode, 5));
		conveyorSystemInputs.add(new ConveyorSystem(a5Node, a10Node, 4));
		conveyorSystemInputs.add(new ConveyorSystem(a5Node, a1Node, 6));
		conveyorSystemInputs.add(new ConveyorSystem(a1Node, a2Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a2Node, a3Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a3Node, a4Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a10Node, a9Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a9Node, a8Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a8Node, a7Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a7Node, a6Node, 1));

		/* Section: Departures */
		List<Departure> departures = new ArrayList<Departure>();
		departures.add(new Departure(FLIGHTID_UA10, a1Node, FLIGHT_DEST_MIA,
				"08:00"));
		departures.add(new Departure(FLIGHTID_UA11, a1Node, FLIGHT_DEST_LAX,
				"09:00"));
		departures.add(new Departure(FLIGHTID_UA12, a1Node, FLIGHT_DEST_JFK,
				"09:45"));
		departures.add(new Departure(FLIGHTID_UA13, a2Node, FLIGHT_DEST_JFK,
				"08:30"));
		departures.add(new Departure(FLIGHTID_UA14, a2Node, FLIGHT_DEST_JFK,
				"09:45"));
		departures.add(new Departure(FLIGHTID_UA15, a2Node, FLIGHT_DEST_JFK,
				"10:00"));
		departures.add(new Departure(FLIGHTID_UA16, a3Node, FLIGHT_DEST_JFK,
				"09:00"));
		departures.add(new Departure(FLIGHTID_UA17, a4Node, FLIGHT_DEST_MHT,
				"09:15"));
		departures.add(new Departure(FLIGHTID_UA18, a5Node, FLIGHT_DEST_LAX,
				"10:15"));

		/* Section: Bags */
		List<Bag> bags = new ArrayList<Bag>();
		bags.add(new Bag(BAG_NUMBER_0001, concourseATicketingNode,
				FLIGHTID_UA12));
		bags.add(new Bag(BAG_NUMBER_0002, a5Node, FLIGHTID_UA17));
		bags.add(new Bag(BAG_NUMBER_0003, a2Node, FLIGHTID_UA10));
		bags.add(new Bag(BAG_NUMBER_0004, a8Node, FLIGHTID_UA18));
		bags.add(new Bag(BAG_NUMBER_0005, a7Node, FLIGHTID_ARRIVAL));
		
		PathFinderInput pathFinderInput = new PathFinderInput(
				conveyorSystemInputs, departures, bags, GRAPH_ALGO_DIJKSTRA);
		PathFinderIntf pathFinder = new PathFinder(pathFinderInput);
		final List<PathFinderOutput> pathFinderOutputs = pathFinder
				.findOptimalPath();
		
		assertNotNull(pathFinderOutputs);
		assertTrue(!pathFinderOutputs.isEmpty());
		
		PathFinderOutput pf0001 = pathFinderOutputs.get(0);
		
		for (PathFinderOutput pathFinderOutput : pathFinderOutputs) {
			System.out.println(pathFinderOutput);
		}
		
		/* Expected */
		List<Node> expectedOptimalPath001 = new CopyOnWriteArrayList<Node>();
		expectedOptimalPath001.add(concourseATicketingNode);
		expectedOptimalPath001.add(a5Node);
		expectedOptimalPath001.add(a1Node);
		assertEquals("0001", pf0001.getBagNumber());
		assertThat(pf0001.getOptimalPath(), is(expectedOptimalPath001));
		assertEquals(new Integer(11), pf0001.getOptimalDistance());
		

	}

	/**
	 * Test for Broken Graph.
	 */
	@Test(expected = PathFinderException.class)
	public void testBrokenGraph() {

		/* Section: Conveyor System */
		List<ConveyorSystem> conveyorSystemInputs = new ArrayList<ConveyorSystem>();
		conveyorSystemInputs.add(new ConveyorSystem(
				concourseATicketingNode, a5Node, 5));
		conveyorSystemInputs.add(new ConveyorSystem(a5Node,
				baggageClaimNode, 5));
		/*
		conveyorSystemInputs.add(new ConveyorSystemInput(a5Node, a10Node, 4)); 
		conveyorSystemInputs.add(new ConveyorSystemInput(a5Node, a1Node, 6));
		conveyorSystemInputs.add(new ConveyorSystemInput(a1Node, a2Node, 1));
		conveyorSystemInputs.add(new ConveyorSystemInput(a2Node, a3Node, 1));
		*/
		conveyorSystemInputs.add(new ConveyorSystem(a3Node, a4Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a10Node, a9Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a9Node, a8Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a8Node, a7Node, 1));
		conveyorSystemInputs.add(new ConveyorSystem(a7Node, a6Node, 1));

		/* Section: Departures */
		List<Departure> departures = new ArrayList<Departure>();
		departures.add(new Departure(FLIGHTID_UA10, a1Node, FLIGHT_DEST_MIA,
				"08:00"));
		departures.add(new Departure(FLIGHTID_UA11, a1Node, FLIGHT_DEST_LAX,
				"09:00"));
		departures.add(new Departure(FLIGHTID_UA12, a1Node, FLIGHT_DEST_JFK,
				"09:45"));
		departures.add(new Departure(FLIGHTID_UA13, a2Node, FLIGHT_DEST_JFK,
				"08:30"));
		departures.add(new Departure(FLIGHTID_UA14, a2Node, FLIGHT_DEST_JFK,
				"09:45"));
		departures.add(new Departure(FLIGHTID_UA15, a2Node, FLIGHT_DEST_JFK,
				"10:00"));
		departures.add(new Departure(FLIGHTID_UA16, a3Node, FLIGHT_DEST_JFK,
				"09:00"));
		departures.add(new Departure(FLIGHTID_UA17, a4Node, FLIGHT_DEST_MHT,
				"09:15"));
		departures.add(new Departure(FLIGHTID_UA18, a5Node, FLIGHT_DEST_LAX,
				"10:15"));

		/* Section: Bags */
		List<Bag> bags = new ArrayList<Bag>();
		bags.add(new Bag(BAG_NUMBER_0001, concourseATicketingNode,
				FLIGHTID_UA12));
		bags.add(new Bag(BAG_NUMBER_0002, a5Node, FLIGHTID_UA17));
		bags.add(new Bag(BAG_NUMBER_0003, a2Node, FLIGHTID_UA10));
		bags.add(new Bag(BAG_NUMBER_0004, a8Node, FLIGHTID_UA18));
		bags.add(new Bag(BAG_NUMBER_0005, a7Node, FLIGHTID_ARRIVAL));

		PathFinderInput pathFinderInput = new PathFinderInput(
				conveyorSystemInputs, departures, bags, GRAPH_ALGO_DIJKSTRA);
		PathFinderIntf pathFinder = new PathFinder(pathFinderInput);
		final List<PathFinderOutput> pathFinderOutputs = pathFinder
				.findOptimalPath();

		
	}

}
