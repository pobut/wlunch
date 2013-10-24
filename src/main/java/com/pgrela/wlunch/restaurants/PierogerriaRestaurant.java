package com.pgrela.wlunch.restaurants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pgrela.wlunch.utils.Downloader;

/**
 * @author: pgrela
 */
public class PierogerriaRestaurant extends AbstractHtmlRestaurant {

    public PierogerriaRestaurant(Downloader downloader) {
        super(downloader);
    }

    @Override
    String getUrl() {
        return "http://www.pierrogeria.eu/";
    }

    protected String getSelector() {
        return "div.scroll-mini ul";
    }

    @Override
    public String getName() {
        return "Pierogerria";
    }

    @Override
    protected String stripMenu(String menu) {
        return menu.replaceAll(" ZUPA 4.*","").replace("do wyboru:", "").replaceAll("^\\-", "");
    }

    @Override
    protected List<Calendar> getPossibleDates(String text) {
        List today = new ArrayList<Calendar>();
        today.add(Calendar.getInstance());
        return today;
    }
}
