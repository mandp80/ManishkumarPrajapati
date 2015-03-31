/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.controller.bean;

import com.barclays.baggagesys.algorithm.bean.Node;

// TODO: Auto-generated Javadoc
/**
 * The Class Departure.
 */
public class Departure {

	/** The flight id. */
	private String flightId;

	/** The flight gate node. */
	private Node flightGateNode;

	/** The destination. */
	private String destination;

	/** The flight time. */
	private String flightTime;

	/**
	 * Instantiates a new departure.
	 *
	 * @param flightId
	 *            the flight id
	 * @param flightGateNode
	 *            the flight gate node
	 * @param destination
	 *            the destination
	 * @param flightTime
	 *            the flight time
	 */
	public Departure(final String flightId, final Node flightGateNode,
			final String destination, final String flightTime) {
		super();
		this.flightId = flightId;
		this.flightGateNode = flightGateNode;
		this.destination = destination;
		this.flightTime = flightTime;
	}

	/**
	 * Gets the flight id.
	 *
	 * @return the flight id
	 */
	public String getFlightId() {
		return flightId;
	}

	/**
	 * Sets the flight id.
	 *
	 * @param flightId
	 *            the new flight id
	 */
	public void setFlightId(final String flightId) {
		this.flightId = flightId;
	}

	/**
	 * Gets the flight gate node.
	 *
	 * @return the flight gate node
	 */
	public Node getFlightGateNode() {
		return flightGateNode;
	}

	/**
	 * Sets the flight gate node.
	 *
	 * @param flightGateNode
	 *            the new flight gate node
	 */
	public void setFlightGateNode(final Node flightGateNode) {
		this.flightGateNode = flightGateNode;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination
	 *            the new destination
	 */
	public void setDestination(final String destination) {
		this.destination = destination;
	}

	/**
	 * Gets the flight time.
	 *
	 * @return the flight time
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Sets the flight time.
	 *
	 * @param flightTime
	 *            the new flight time
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

}
