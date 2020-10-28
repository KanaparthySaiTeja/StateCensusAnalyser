import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCodeAnalyserTest {
    public static final String STATECODE_CSVFILE= "C:\\Users\\USER\\Desktop\\files\\StateCode.csv";
    public static final String STATECODE_CSVFILEWRONGDELIMITER= "C:\\Users\\USER\\Desktop\\files\\StateCodedelimiter.csv";
    public static final String STATECODE_CSVFILEWRONGHEADER= "C:\\Users\\USER\\Desktop\\files\\StateCodeheader.csv";
    public static final String STATECODE_CSVFILEWRONGTYPE= "C:\\Users\\USER\\Desktop\\files\\StateCodepdf.pdf";
    public static final String STATECODE_CSVFILEWRONGPATH= "C:\\Users\\USER\\StateCensusData.csv";
    @Test
    public void GivenStateCodesCsvFile_IfCorrectNumOfRecords_Should_ReturnTrue() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODE_CSVFILE, StateCode.class);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (CensusException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void GivenStateCensusCsvFile_If_DoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODE_CSVFILEWRONGDELIMITER, StateCode.class);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

}