/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.controller.bean;

import com.barclays.baggagesys.algorithm.bean.Node;

// TODO: Auto-generated Javadoc
/**
 * The Class Bag.
 */
public class Bag {

	/** The bag number. */
	private String bagNumber;

	/** The entry point node. */
	private Node entryPointNode;

	/** The flight id. */
	private String flightId;

	/**
	 * Instantiates a new bag.
	 *
	 * @param bagNumber
	 *            the bag number
	 * @param entryPointNode
	 *            the entry point node
	 * @param flightId
	 *            the flight id
	 */
	public Bag(final String bagNumber, final Node entryPointNode,
			final String flightId) {
		super();
		this.bagNumber = bagNumber;
		this.entryPointNode = entryPointNode;
		this.flightId = flightId;
	}

	/**
	 * Gets the bag number.
	 *
	 * @return the bag number
	 */
	public String getBagNumber() {
		return bagNumber;
	}

	/**
	 * Sets the bag number.
	 *
	 * @param bagNumber
	 *            the new bag number
	 */
	public void setBagNumber(final String bagNumber) {
		this.bagNumber = bagNumber;
	}

	/**
	 * Gets the entry point node.
	 *
	 * @return the entry point node
	 */
	public Node getEntryPointNode() {
		return entryPointNode;
	}

	/**
	 * Sets the entry point node.
	 *
	 * @param entryPointNode
	 *            the new entry point node
	 */
	public void setEntryPointNode(final Node entryPointNode) {
		this.entryPointNode = entryPointNode;
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

}
