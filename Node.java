/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.algorithm.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node implements Comparable<Node>{

	/** The id. */
	final private String id;

	/** The distance. */
	private int distance = Integer.MAX_VALUE;

	/**
	 * Instantiates a new node.
	 *
	 * @param id
	 *            the id
	 */
	public Node(final String id) {
		this.id = id;
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
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Sets the distance.
	 *
	 * @param distance the new distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null) {
			final Node otherNode = (Node) obj;
			if (this == obj || id.equals(otherNode.id)) {
				equal = true;
			}

		}
		return equal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Node o) {
		if(this.getDistance() > o.getDistance()){
			return 1;
		}
		else{
			return -1;
		}
	}

}
