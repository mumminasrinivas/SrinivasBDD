package csvFileCompare;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComparePositionReportFinal {
    public static void main(String[] args) {
    	 String instrumentFile = "C:\\Users\\Dell\\eclipse-workspace\\SrinivasBDDProject\\src\\test\\resources\\InstrumentDetails.csv";
         String positionDetailsFile = "C:\\Users\\Dell\\eclipse-workspace\\SrinivasBDDProject\\src\\test\\resources\\PositionDetails.csv";
         String positionReportFile = "C:\\Users\\Dell\\eclipse-workspace\\SrinivasBDDProject\\src\\test\\resources\\PositionReport.csv";

        try {
            // Read the InstrumentDetails.csv file
            BufferedReader instrumentReader = new BufferedReader(new FileReader(instrumentFile));
            String instrumentLine;

            // Skip the header line in InstrumentDetails.csv
            instrumentReader.readLine();

            // Read each line in InstrumentDetails.csv
            while ((instrumentLine = instrumentReader.readLine()) != null) {
                String[] instrumentData = instrumentLine.split(",");

                // Extract ISIN and Unit Price from InstrumentDetails.csv
                String isin = instrumentData[2];
                String unitPrice = instrumentData[3];

                // Read the PositionDetails.csv file
                BufferedReader positionDetailsReader = new BufferedReader(new FileReader(positionDetailsFile));
                String positionDetailsLine;

                // Skip the header line in PositionDetails.csv
                positionDetailsReader.readLine();

                boolean matchFound = false;

                // Read each line in PositionDetails.csv
                while ((positionDetailsLine = positionDetailsReader.readLine()) != null) {
                    String[] positionDetailsData = positionDetailsLine.split(",");

                    // Extract PositionID and Quantity from PositionDetails.csv
                    String positionId = positionDetailsData[0];
                    int quantity = Integer.parseInt(positionDetailsData[2]);

                    // Read the PositionReport.csv file
                    BufferedReader positionReportReader = new BufferedReader(new FileReader(positionReportFile));
                    String positionReportLine;

                    // Skip the header line in PositionReport.csv
                    positionReportReader.readLine();

                    // Read each line in PositionReport.csv
                    while ((positionReportLine = positionReportReader.readLine()) != null) {
                        String[] positionReportData = positionReportLine.split(",");

                        // Extract PositionID, ISIN, Quantity, and Unit Price from PositionReport.csv
                        String reportPositionId = positionReportData[1];
                        String reportIsin = positionReportData[2];
                        int reportQuantity = Integer.parseInt(positionReportData[3]);
                        String reportUnitPrice = positionReportData[4];
                        String reportTotalPrice = positionReportData[5];

                        // Compare the ISIN, Unit Price, and Quantity values
                        if (reportPositionId.equals(positionId) && reportIsin.equals(isin) &&
                                reportUnitPrice.equals(unitPrice) && reportQuantity == quantity) {
                            // Calculate the expected Total Price
                            int expectedTotalPrice = quantity * Integer.parseInt(unitPrice);

                            // Compare the Total Price
                            if (reportTotalPrice.equals(String.valueOf(expectedTotalPrice))) {
                                matchFound = true;
                                System.out.println("PositionID: " + positionId + ", ISIN: " + isin +
                                        ", Quantity: " + quantity + ", Unit Price: " + unitPrice +
                                        ", and Total Price: " + reportTotalPrice + " are matching with Expected output");
                            }
                            break;
                        }
                    }

                    // Close the PositionReport.csv reader
                    positionReportReader.close();
                }

                // Close the PositionDetails.csv reader
                positionDetailsReader.close();
            }

            // Close the InstrumentDetails.csv reader
            instrumentReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
