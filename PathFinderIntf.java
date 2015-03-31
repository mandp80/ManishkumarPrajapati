/*
* Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*/
package com.barclays.baggagesys.controller;

import java.util.List;

import com.barclays.baggagesys.controller.bean.PathFinderOutput;

// TODO: Auto-generated Javadoc
/**
 * The Interface PathFinderIntf.
 */
public interface PathFinderIntf {
	
	/**
	 * Find optimal path.
	 *
	 * @return the list
	 */
	public List<PathFinderOutput> findOptimalPath();
}
