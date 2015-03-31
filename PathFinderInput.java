/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.controller.bean;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PathFinderInput.
 */
public class PathFinderInput {

	/** The conveyor system. */
	private List<ConveyorSystem> conveyorSystemInputs;

	/** The departures. */
	private List<Departure> departures;

	/** The bags. */
	private List<Bag> bags;

	/** The graph algorithm str. */
	private String graphAlgorithmStr;

	/**
	 * Instantiates a new path finder input.
	 *
	 * @param conveyorSystemInputs
	 *            the conveyor system inputs
	 * @param departures
	 *            the departures
	 * @param bags
	 *            the bags
	 * @param graphAlgorithmStr
	 *            the graph algorithm str
	 */
	public PathFinderInput(
			final List<ConveyorSystem> conveyorSystemInputs,
			final List<Departure> departures, final List<Bag> bags,
			final String graphAlgorithmStr) {
		super();
		this.conveyorSystemInputs = conveyorSystemInputs;
		this.departures = departures;
		this.bags = bags;
		this.graphAlgorithmStr = graphAlgorithmStr;
	}

	/**
	 * Gets the conveyor system inputs.
	 *
	 * @return the conveyor system inputs
	 */
	public List<ConveyorSystem> getConveyorSystemInputs() {
		return conveyorSystemInputs;
	}

	/**
	 * Sets the conveyor system inputs.
	 *
	 * @param conveyorSystemInputs
	 *            the new conveyor system inputs
	 */
	public void setConveyorSystemInputs(
			final List<ConveyorSystem> conveyorSystemInputs) {
		this.conveyorSystemInputs = conveyorSystemInputs;
	}

	/**
	 * Gets the departures.
	 *
	 * @return the departures
	 */
	public List<Departure> getDepartures() {
		return departures;
	}

	/**
	 * Sets the departures.
	 *
	 * @param departures
	 *            the new departures
	 */
	public void setDepartures(final List<Departure> departures) {
		this.departures = departures;
	}

	/**
	 * Gets the bags.
	 *
	 * @return the bags
	 */
	public List<Bag> getBags() {
		return bags;
	}

	/**
	 * Sets the bags.
	 *
	 * @param bags
	 *            the new bags
	 */
	public void setBags(final List<Bag> bags) {
		this.bags = bags;
	}

	/**
	 * Gets the graph algorithm str.
	 *
	 * @return the graph algorithm str
	 */
	public String getGraphAlgorithmStr() {
		return graphAlgorithmStr;
	}

	/**
	 * Sets the graph algorithm str.
	 *
	 * @param graphAlgorithmStr
	 *            the new graph algorithm str
	 */
	public void setGraphAlgorithmStr(final String graphAlgorithmStr) {
		this.graphAlgorithmStr = graphAlgorithmStr;
	}

}
