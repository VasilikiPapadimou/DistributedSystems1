package lab_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{
    MyObjectOutputStream(FileOutputStream fos) throws IOException{
        super(fos);
    }
    // Κάνουμε override την μέθοδο ώστε όταν ανοίξουμε το αρχείο για Append να μην ξαναγράφει την κεφαλίδα
    @Override
  protected void writeStreamHeader() throws IOException {
    reset();
  }
}
