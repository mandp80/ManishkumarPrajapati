/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.algorithm.bean;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph.
 */
public class Graph {

	/** The vertexes. */
	private final List<Node> nodes;

	/** The edges. */
	private final List<Edge> edges;

	/**
	 * Instantiates a new graph.
	 *
	 * @param nodes
	 *            the nodes
	 * @param edges
	 *            the edges
	 */
	public Graph(final List<Node> nodes, final List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	/**
	 * Gets the nodes.
	 *
	 * @return the nodes
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * Gets the edges.
	 *
	 * @return the edges
	 */
	public List<Edge> getEdges() {
		return edges;
	}

}
