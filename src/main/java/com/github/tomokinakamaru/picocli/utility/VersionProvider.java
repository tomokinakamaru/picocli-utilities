package com.github.tomokinakamaru.picocli.utility;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;
import picocli.CommandLine;

final class VersionProvider implements CommandLine.IVersionProvider {

  @Override
  public String[] getVersion() {
    return new String[] {getManifest().getMainAttributes().getValue("Version")};
  }

  private Manifest getManifest() {
    try {
      return new Manifest(getURLStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private InputStream getURLStream() {
    try {
      return getResources().nextElement().openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Enumeration<URL> getResources() {
    try {
      return VersionProvider.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}