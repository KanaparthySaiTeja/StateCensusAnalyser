import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTest {
    public static final String STATECENSUS_CSVFILE= "C:\\Users\\USER\\Desktop\\files\\StateCensusData.csv";
    public static final String STATECENSUS_CSVFILEWRONGDELIMITER= "C:\\Users\\USER\\Desktop\\files\\StateCensusDatadelimiter.csv";
    public static final String STATECENSUS_CSVFILEWRONGHEADER= "C:\\Users\\USER\\Desktop\\files\\StateCensusDataheader.csv";
    public static final String STATECENSUS_CSVFILEWRONGTYPE= "C:\\Users\\USER\\Desktop\\files\\statecensuspdf.pdf";
    public static final String STATECENSUS_CSVFILEWRONGPATH= "C:\\Users\\USER\\StateCensusData.csv";
    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (CensusException e) {
            e.printStackTrace();
        }
    }
}