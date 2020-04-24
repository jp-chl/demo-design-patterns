package com.jpvr.demodesignpatterns.dp.structural.bridge;

import java.util.List;

public class HtmlFormatter implements Formatter {

    @Override
    public String format(String header, List<Detail> details) {

        StringBuilder builder = new StringBuilder();

        builder.append("<table>");
        builder.append("<th>");
        builder.append("Classification");
        builder.append("</th>");
        builder.append("<th>");
        builder.append(header);
        builder.append("</th>");

        for(Detail detail : details) {

            builder.append("<tr>");
                builder.append("<td>");
                    builder.append(detail.getLabel());
                builder.append("</td>");
            builder.append("</tr>");

            builder.append("<tr>");
                builder.append("<td>");
                    builder.append(detail.getValue());
                builder.append("</td>");
            builder.append("</tr>");
        } // end iteration

        builder.append("</table>");

        return builder.toString();
    } // end String format(String header, List<Detail> details)
} // end class HtmlFormatter implements Formatter
