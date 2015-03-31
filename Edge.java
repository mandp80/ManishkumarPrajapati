/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.algorithm.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class Edge.
 */
public class Edge {

	/** The id. */
	private final String id;

	/** The source. */
	private final Node source;

	/** The destination. */
	private final Node destination;

	/** The weight. */
	private final int weight;

	/**
	 * Instantiates a new edge.
	 *
	 * @param id
	 *            the id
	 * @param source
	 *            the source
	 * @param destination
	 *            the destination
	 * @param weight
	 *            the weight
	 */
	public Edge(final String id, final Node source, final Node destination,
			final int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public Node getDestination() {
		return destination;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public Node getSource() {
		return source;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return source + " " + destination;
	}

}
