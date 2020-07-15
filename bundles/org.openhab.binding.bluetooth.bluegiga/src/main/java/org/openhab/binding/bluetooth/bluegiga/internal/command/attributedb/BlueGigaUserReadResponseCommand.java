/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.bluetooth.bluegiga.internal.command.attributedb;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.bluetooth.bluegiga.internal.BlueGigaDeviceCommand;

/**
 * Class to implement the BlueGiga command <b>userReadResponse</b>.
 * <p>
 * This command is used to respond to an attribute Read request by a remote device, but only for
 * attributes which have been configured with the user property. Attributes which have the
 * user property enabled allow the attribute value to be requested from the application
 * instead of the Smart stack automatically responding with Bluetooth the data in it's local
 * GATT database. This command is normally used in response to a User Read Request event, which
 * is generated when a remote device tries to read an attribute with a user property enabled. The
 * response to User Read Request events must happen within 30 seconds or otherwise a timeout
 * will occur.
 * <p>
 * This class provides methods for processing BlueGiga API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
@NonNullByDefault
public class BlueGigaUserReadResponseCommand extends BlueGigaDeviceCommand {
    public static int COMMAND_CLASS = 0x02;
    public static int COMMAND_METHOD = 0x03;

    /**
     * 0: User Read Request is responded with data. In case of an error an application specific error
     * code can be sent.
     * <p>
     * BlueGiga API type is <i>uint8</i> - Java type is {@link int}
     */
    private int attError;

    /**
     * Data to send
     * <p>
     * BlueGiga API type is <i>uint8array</i> - Java type is {@link int[]}
     */
    private int[] value = new int[0];

    /**
     * 0: User Read Request is responded with data. In case of an error an application specific error
     * code can be sent.
     *
     * @param attError the attError to set as {@link int}
     */
    public void setAttError(int attError) {
        this.attError = attError;
    }

    /**
     * Data to send
     *
     * @param value the value to set as {@link int[]}
     */
    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(COMMAND_CLASS, COMMAND_METHOD);

        // Serialize the fields
        serializeUInt8(connection);
        serializeUInt8(attError);
        serializeUInt8Array(value);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BlueGigaUserReadResponseCommand [connection=");
        builder.append(connection);
        builder.append(", attError=");
        builder.append(attError);
        builder.append(", value=");
        for (int c = 0; c < value.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", value[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}
