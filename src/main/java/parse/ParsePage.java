package parse;

import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import product.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsePage {

    private static Document document = getDocument();
    private static List<Item> items = new ArrayList<>();

    private ParsePage() {
    }

    private static Document getDocument() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.jencorp.net/en/net/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }


    public static void getInfo() {
        Elements tables = document.getElementById("item_lists").getElementsByTag("tbody");
        String rootElement = "detail_line";
        String tag = "td";

        for (int i = 0; i < tables.size(); i++) {

            Element table = document.getElementById("item_lists").getElementsByTag("tbody").get(i);

            String auctionNo = table.getElementsByClass(rootElement).get(0).getElementsByTag(tag).get(0).text();
            String maker = table.getElementsByClass(rootElement).get(0).getElementsByTag(tag).get(1).text();
            String year = table.getElementsByClass(rootElement).get(0).getElementsByTag(tag).get(2).text();
            String hour = table.getElementsByClass(rootElement).get(0).getElementsByTag(tag).get(3).text();
            String deliveryYard = table.getElementsByClass(rootElement).get(0).getElementsByTag(tag).get(4).text();
            String releasingCharge = table.getElementsByClass(rootElement).get(0).getElementsByTag(tag).get(5).text();

            String modelSerial = table.getElementsByClass(rootElement).get(1).getElementsByTag(tag).get(0).text();
            String currentBid = table.getElementsByClass(rootElement).get(1).getElementsByTag(tag).get(1).text();
            String bidderNo = table.getElementsByClass(rootElement).get(1).getElementsByTag(tag).get(2).text();
            String bids = table.getElementsByClass(rootElement).get(1).getElementsByTag(tag).get(3).text();
            String timeLeft = table.getElementsByClass(rootElement).get(1).getElementsByTag(tag).get(4).text();

            String feature = table.getElementsByClass("last_line").get(0).getElementsByTag(tag).get(0).text();

            Item item = new Item(
                    auctionNo,
                    maker,
                    year,
                    hour,
                    deliveryYard,
                    releasingCharge,
                    modelSerial,
                    currentBid,
                    bidderNo,
                    bids,
                    timeLeft,
                    feature
            );

            items.add(item);
        }

    }


    public static void writeToFile(File file) {

        FileWriter outputFile = null;
        try {
            outputFile = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVWriter writer = new CSVWriter(outputFile);


        // adding header to csv
        String[] header = {
                "Auction No.", "Maker", "Year", "Hour", "Delivery Yard", "Releasing Charge",
                "Model / Serial", "Current Bid", "Bidder No.", "Bids", "Time Left", "Feature"};
        writer.writeNext(header);

        // add data to csv
        items.stream()
                .map(item -> new String[]{
                        item.getAuctionNo(), item.getMaker(), item.getYear(), item.getHour(), item.getDeliveryYard(),
                        item.getReleasingCharge(), item.getModelSerial(), item.getCurrentBid(), item.getBidderNo(),
                        item.getBids(), item.getTimeLeft(), item.getFeature()})
                .forEach(writer::writeNext);

        // closing writer connection
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
