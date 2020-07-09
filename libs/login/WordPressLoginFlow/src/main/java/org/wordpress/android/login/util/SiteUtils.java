package org.wordpress.android.login.util;

import java.util.ArrayList;
import java.util.List;
import org.wordpress.android.fluxc.model.SiteModel;
import org.wordpress.android.fluxc.store.SiteStore;

public class SiteUtils {
  public static ArrayList<Integer> getCurrentSiteIds(SiteStore siteStore,
                                                     boolean selfhostedOnly) {
    ArrayList<Integer> siteIDs = new ArrayList<>();
    List<SiteModel> sites = selfhostedOnly
                                ? siteStore.getSitesAccessedViaXMLRPC()
                                : siteStore.getSites();
    for (SiteModel site : sites) {
      siteIDs.add(site.getId());
    }

    return siteIDs;
  }
}
