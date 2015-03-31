/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.algorithm;

import java.util.List;

import com.barclays.baggagesys.algorithm.bean.Node;

// TODO: Auto-generated Javadoc
/**
 * The Interface GrapthAlogrithm.
 */
public interface GraphAlogrithm {

	/**
	 * Execute.
	 *
	 * @param source
	 *            the source
	 */
	public void execute(Node source);

	/**
	 * Gets the optimal path.
	 *
	 * @param target
	 *            the target
	 * @return the optimal path
	 */
	public List<Node> getOptimalPath(Node target);

	/**
	 * Gets the optimal distances.
	 *
	 * @param target
	 *            the target
	 * @return the optimal distances
	 */
	public Integer getOptimalDistances(Node target);
}
