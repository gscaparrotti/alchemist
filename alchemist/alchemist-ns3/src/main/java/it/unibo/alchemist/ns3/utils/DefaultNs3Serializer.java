/*
 * Copyright (C) 2010-2020, Danilo Pianini and contributors
 * listed in the main project's alchemist/build.gradle.kts file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */

package it.unibo.alchemist.ns3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class DefaultNs3Serializer implements Serializer {

    @Override
    public void serializeAndSend(final Object toSend, final OutputStream outputStream) throws IOException {
        final var oos = new ObjectOutputStream(outputStream);
        oos.writeObject(toSend);
        oos.flush();
        oos.close();
    }

    @Override
    public Object deserialize(final InputStream inputStream) throws IOException, ClassNotFoundException {
        final var ois = new ObjectInputStream(inputStream);
        final var received = ois.readObject();
        ois.close();
        return received;
    }

}
