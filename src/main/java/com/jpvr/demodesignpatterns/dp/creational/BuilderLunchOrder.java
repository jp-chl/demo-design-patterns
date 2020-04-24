package com.jpvr.demodesignpatterns.dp.creational;

public class BuilderLunchOrder {

    // final to make it immutable
    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    private BuilderLunchOrder(Builder builder) {
        bread = builder.bread;
        condiments = builder.condiments;
        dressing = builder.dressing;
        meat = builder.meat;
    } // end

    @Override
    public String toString() {
        return "LunchOrder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    } // end String toString()

    /**
     * In order to avoid new at instance creation time
     * a static constructor can be made available
     * @return Builder instance
     */
//    public static Builder Builder() {
//
//        return new Builder();
//    } // end

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    /**
     * Builder class
     */
    public static class Builder {

        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        // A contract can be define here
        // with required parameters to
        // this constructor
        public Builder() {

        } // end public Builder()

        public BuilderLunchOrder build() {

            return new BuilderLunchOrder(this);
        } // end

        public Builder bread(String val) {
            bread = val;
            return this;
        } // end

        public Builder condiments(String val) {
            condiments = val;
            return this;
        } // end

        public Builder dressing(String val) {
            dressing = val;
            return this;
        } // end

        public Builder meat(String val) {
            meat = val;
            return this;
        } // end
    } // end public static class Builder
} // end class LunchOrderBean
