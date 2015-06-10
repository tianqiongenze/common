package com.intel.sto.bigdata.dew.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Files {

  private Files() {
  }


  public static Set<String> loadResourceFile(InputStream is) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    Set<String> lines = new HashSet<String>();
    String line;
    while ((line = br.readLine()) != null) {
      if (!line.startsWith("#")) {
        lines.add(line);
      }
    }
    br.close();
    return lines;
  }

  public static Map<String, String> loadPropertiesFile(InputStream is) throws Exception {
    Set<String> set = loadResourceFile(is);
    Map<String, String> map = new HashMap<String, String>();
    for (String line : set) {
      if (line == null || line.trim().equals("")) {
        continue;
      }
      String[] kv = line.split("=");
      if (kv == null || kv.length != 2) {
        throw new Exception("Failed load properties file because of " + line);
      }
      map.put(kv[0].trim(), kv[1].trim());
    }
    return map;
  }

  public static Map<String, String> loadPropertiesFile(String fileName) throws Exception {
    return loadPropertiesFile(Files.class.getResourceAsStream(fileName));
  }

  public static Set<String> loadResourceFile(String fileName) throws Exception {
    return loadResourceFile(Files.class.getResourceAsStream(fileName));
  }

}
