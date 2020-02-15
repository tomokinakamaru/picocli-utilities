package com.github.tomokinakamaru.utility.picocli;

import com.github.tomokinakamaru.manifestattributes.ManifestAttributes;
import picocli.CommandLine.IVersionProvider;

final class VersionProvider implements IVersionProvider {

  @Override
  public String[] getVersion() {
    return new String[] {new ManifestAttributes(VersionProvider.class).get("Version")};
  }
}
