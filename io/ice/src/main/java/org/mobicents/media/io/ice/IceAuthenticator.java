/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package org.mobicents.media.io.ice;

/**
 * Authenticator that verifies the integrity of incoming messages.
 * 
 * @author Henrique Rosa
 * 
 */
public interface IceAuthenticator {

	/**
	 * Gets the password assigned to a local user.
	 * 
	 * @param ufrag
	 *            the fragment of the local user
	 * @return The password of the specified user.<br>
	 *         If the user has no password associated, returns an empty key.<br>
	 *         If the user does not exist, returns null.
	 */
	public byte[] getLocalKey(String ufrag);

	/**
	 * Gets the password assigned to a remote user.
	 * 
	 * @param ufrag
	 *            the fragment of the remote user
	 * @param media
	 *            the name of the target media stream
	 * @return The password of the specified user.<br>
	 *         If the user has no password associated, returns an empty key.<br>
	 *         If the user or media stream do not exist, returns null.
	 */
	public byte[] getRemoteKey(String ufrag, String media);

	/**
	 * Verifies whether a local user is registered.
	 * 
	 * @param ufrag
	 *            the fragment of the local user
	 * @return true if the user exists, false otherwise.
	 */
	boolean isUserRegistered(String ufrag);

	/**
	 * Validates the autenticity of a STUN USERNAME attribute.<br>
	 * The agent MUST consider the username to be valid if it consists of two
	 * values separated by a colon, where the first value is equal to the
	 * username fragment generated by the agent in an offer or answer for a
	 * session in-progress.
	 * 
	 * @param username The username to be validated
	 * @return Whether the username is valid or not.
	 */
	boolean validateUsername(String username);
}
