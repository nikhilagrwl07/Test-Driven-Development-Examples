import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


public class MySetTest {

    private MySet mySet;

    @Before
    public void setUp() throws Exception {
        mySet = new MySet();
    }


    @Test
    public void insertNewElement(){
        //Arrange
         int newElement = 1;

         //Act
        boolean result = mySet.insert(newElement);
        //test
        assertEquals(result,true);
        assertEquals(mySet.size(),1);
    }

    @Test
    public void insertDuplicateElement(){
        //Arrange
        int newElement = 1;
        int duplicateElement = 1;

        //Act
        boolean result = mySet.insert(newElement);
        boolean resultOfDuplicate = mySet.insert(duplicateElement);
        //test
        assertEquals(result,true);
        assertEquals(resultOfDuplicate,false);
        assertEquals(mySet.size(),1);
    }

    @Test
    public void insertWhenSetIsFull(){
        //Arrange
        int intialSizeOfSet = 10;
        int element = 11;

        //Act
        mySet = new MySet(intialSizeOfSet);

        for(int i=0;i<intialSizeOfSet;i++){
            mySet.insert(i+1);
        }

        boolean result = mySet.insert(element);

        //test
        assertEquals(result,true);
        assertEquals(mySet.size(),11);

    }

    @Test
    public void getSizeOnEmptySet(){
        //Arrange

        //Act
        int result = mySet.size();

        //test
        assertEquals(result,0);
    }

    @Test
    public void getSizeOnHalfFilledSet(){
        //Arrange
        int intialLengthOfSet = 10;
        int halfLength = 5;
        mySet = new MySet(intialLengthOfSet);

        for(int i=0;i<halfLength;i++){
            mySet.insert(i+1);
        }

        //Act
        int result = mySet.size();

        //test
        assertEquals(result,halfLength);
    }

    @Test
    public void getSizeOnFullyFilledSet(){
        //Arrange
        int intialLengthOfSet = 10;
        mySet = new MySet(intialLengthOfSet);

        for(int i=0;i<intialLengthOfSet;i++){
            mySet.insert(i+1);
        }

        //Act
        int result = mySet.size();

        //test
        assertEquals(result,intialLengthOfSet);
    }

    @Test
    public void deleteAnyElementFromSet(){
        //Arrange
        int intialLengthOfSet = 10;
        int elementToBeDeleted =5;

        mySet = new MySet(intialLengthOfSet);

        for(int i=0;i<intialLengthOfSet;i++){
            mySet.insert(i+1);
        }

        //Act
        boolean  result = mySet.delete(elementToBeDeleted);

        //test
        assertEquals(result,true);
        assertEquals(mySet.size(),intialLengthOfSet-1);
        assertEquals(mySet.exists(elementToBeDeleted),false);
    }

    @Test
    public void deleteAnyElementFromEmptySet(){
        //Arrange
        int intialLengthOfSet = 10;
        int elementToBeDeleted =5;

        mySet = new MySet(intialLengthOfSet);

        //Act
        boolean  result = mySet.delete(elementToBeDeleted);

        //test
        assertEquals(result,false);
        assertEquals(mySet.size(),0);
        assertEquals(mySet.exists(elementToBeDeleted),false);
    }

    @Test
    public void checkElementFromEmptySet(){
        //Arrange
        int intialLengthOfSet = 10;
        int element =5;

        mySet = new MySet(intialLengthOfSet);

        //Act
        boolean result = mySet.exists(element);

        //test
        assertEquals(result,false);
    }

    @Test
    public void checkElementFromNonEmptySet(){
        //Arrange
        int intialLengthOfSet = 10;
        int element =5;

        mySet = new MySet(intialLengthOfSet);
        mySet.insert(5);

        //Act
        boolean result = mySet.exists(element);

        //test
        assertEquals(result,true);
    }

}
