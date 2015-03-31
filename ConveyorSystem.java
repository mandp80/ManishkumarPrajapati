/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.controller.bean;

import com.barclays.baggagesys.algorithm.bean.Node;

// TODO: Auto-generated Javadoc
/**
 * The Class ConveyorSystemInput.
 */
public class ConveyorSystem {

	/** The node1. */
	private Node node1;

	/** The node2. */
	private Node node2;

	/** The travel time. */
	private Integer travelTime;

	/**
	 * Instantiates a new conveyor system input.
	 *
	 * @param node1
	 *            the node1
	 * @param node2
	 *            the node2
	 * @param travelTime
	 *            the travel time
	 */
	public ConveyorSystem(final Node node1, final Node node2,
			final Integer travelTime) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.travelTime = travelTime;
	}

	/**
	 * Gets the node1.
	 *
	 * @return the node1
	 */
	public Node getNode1() {
		return node1;
	}

	/**
	 * Sets the node1.
	 *
	 * @param node1
	 *            the new node1
	 */
	public void setNode1(final Node node1) {
		this.node1 = node1;
	}

	/**
	 * Gets the node2.
	 *
	 * @return the node2
	 */
	public Node getNode2() {
		return node2;
	}

	/**
	 * Sets the node2.
	 *
	 * @param node2
	 *            the new node2
	 */
	public void setNode2(final Node node2) {
		this.node2 = node2;
	}

	/**
	 * Gets the travel time.
	 *
	 * @return the travel time
	 */
	public Integer getTravelTime() {
		return travelTime;
	}

	/**
	 * Sets the travel time.
	 *
	 * @param travelTime
	 *            the new travel time
	 */
	public void setTravelTime(final Integer travelTime) {
		this.travelTime = travelTime;
	}

}
