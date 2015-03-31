/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.factory;

import static com.barclays.baggagesys.constant.BaggageSystemConstants.GRAPH_ALGO_DIJKSTRA;

import com.barclays.baggagesys.algorithm.DijkstraAlgorithm;
import com.barclays.baggagesys.algorithm.GraphAlogrithm;
import com.barclays.baggagesys.algorithm.bean.Graph;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating GraphAlgorithm objects.
 */
public final class GraphAlgorithmFactory {

	/** The graph algorithm. */
	private static GraphAlogrithm graphAlgorithm;

	/**
	 * Private Constructor Instantiates a new graph algorithm factory.
	 */
	private GraphAlgorithmFactory() {

	}

	/**
	 * Gets the single instance of GraphAlgorithmFactory.
	 *
	 * @param graph
	 *            the graph
	 * @param graphAlgorithmStr
	 *            the graph algorithm str
	 * @return single instance of GraphAlgorithmFactory
	 */
	public static GraphAlogrithm getGraphAlgorithm(final Graph graph,
			final String graphAlgorithmStr) {
		if (GRAPH_ALGO_DIJKSTRA.equalsIgnoreCase(graphAlgorithmStr)) {
			graphAlgorithm = new DijkstraAlgorithm(graph);
		}
		return graphAlgorithm;
	}
}
