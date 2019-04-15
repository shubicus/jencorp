package product;

public class Item {

    private String auctionNo;
    private String maker;
    private String year;
    private String hour;
    private String deliveryYard;
    private String releasingCharge;
    private String modelSerial;
    private String currentBid;
    private String bidderNo;
    private String bids;
    private String timeLeft;
    private String feature;


    public Item(String auctionNo, String maker, String year, String hour, String deliveryYard, String releasingCharge,
                String modelSerial, String currentBid, String bidderNo, String bids, String timeLeft, String feature) {
        this.auctionNo = auctionNo;
        this.maker = maker;
        this.year = year;
        this.hour = hour;
        this.deliveryYard = deliveryYard;
        this.releasingCharge = releasingCharge;
        this.modelSerial = modelSerial;
        this.currentBid = currentBid;
        this.bidderNo = bidderNo;
        this.bids = bids;
        this.timeLeft = timeLeft;
        this.feature = feature;
    }


    public String getAuctionNo() {
        return auctionNo;
    }

    public String getMaker() {
        return maker;
    }

    public String getYear() {
        return year;
    }

    public String getHour() {
        return hour;
    }

    public String getDeliveryYard() {
        return deliveryYard;
    }

    public String getReleasingCharge() {
        return releasingCharge;
    }

    public String getModelSerial() {
        return modelSerial;
    }

    public String getCurrentBid() {
        return currentBid;
    }

    public String getBidderNo() {
        return bidderNo;
    }

    public String getBids() {
        return bids;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public String getFeature() {
        return feature;
    }
}