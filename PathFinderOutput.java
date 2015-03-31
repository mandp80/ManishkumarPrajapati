/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.controller.bean;

import java.util.List;

import com.barclays.baggagesys.algorithm.bean.Node;

// TODO: Auto-generated Javadoc
/**
 * The Class PathFinderOutput.
 */
public class PathFinderOutput {

	/** The bag number. */
	private String bagNumber;

	/** The optimal path. */
	private List<Node> optimalPath;

	/** The optimal distance. */
	private Integer optimalDistance;

	/**
	 * Instantiates a new path finder output.
	 *
	 * @param bagNumber
	 *            the bag number
	 * @param optimalPath
	 *            the optimal path
	 * @param optimalDistance
	 *            the optimal distance
	 */
	public PathFinderOutput(final String bagNumber,
			final List<Node> optimalPath, final Integer optimalDistance) {
		super();
		this.bagNumber = bagNumber;
		this.optimalPath = optimalPath;
		this.optimalDistance = optimalDistance;
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
	 * Gets the optimal path.
	 *
	 * @return the optimal path
	 */
	public List<Node> getOptimalPath() {
		return optimalPath;
	}

	/**
	 * Sets the optimal path.
	 *
	 * @param optimalPath
	 *            the new optimal path
	 */
	public void setOptimalPath(final List<Node> optimalPath) {
		this.optimalPath = optimalPath;
	}

	/**
	 * Gets the optimal distance.
	 *
	 * @return the optimal distance
	 */
	public Integer getOptimalDistance() {
		return optimalDistance;
	}

	/**
	 * Sets the optimal distance.
	 *
	 * @param optimalDistance
	 *            the new optimal distance
	 */
	public void setOptimalDistance(final Integer optimalDistance) {
		this.optimalDistance = optimalDistance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return bagNumber + " : " + optimalPath + " : " + optimalDistance;
	}

}
