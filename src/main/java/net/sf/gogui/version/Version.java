//----------------------------------------------------------------------------
// The file Version.java is automatically created from Version.java.in.
// Do not edit Version.java.
//----------------------------------------------------------------------------

package net.sf.gogui.version;

import java.io.IOException;
import java.util.Properties;

/** Version information for all packages. */
public final class Version
{
    /** Get version for packages in net.sf.gogui.
        @return Version string, no assumptions about the format should be
        made.
    */
    private static Version instance = null;
    private String version;
    public static String get()
    {
        if(instance == null){
            instance = new Version();
        }
        return instance.version;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Version()
    {
	      Properties properties = new Properties();
	      try {
			properties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));
            version = properties.get("git.commit.id.describe").toString();
          } catch (IOException e) {
            // TODO : logger.error("Error on retrieving version from git.properties", e);
            version = "No Version";
          }
    }
}
