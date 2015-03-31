/*
 * Copyright (c) 2015, Manishkumar Prajapati. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.barclays.baggagesys.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class PathFinderException.
 */
public class PathFinderException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8056866836645693446L;

	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new path finder exception.
	 */
	public PathFinderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new path finder exception.
	 *
	 * @param message
	 *            the message
	 */
	public PathFinderException(final String message) {
		super(message);
		this.errorMessage = message;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage
	 *            the new error message
	 */
	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return "PathFinderException [errorMessage=" + errorMessage + "]";
	}
}
