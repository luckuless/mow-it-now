package com.mow;

import com.mow.model.Tondeuses;
import com.mow.service.FileService;
import com.mow.service.impl.FileServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final FileService fileService = new FileServiceImpl();
        System.out.println( "Hello World!" );
        String fileName = "src/main/resources/instructions.txt";

        Tondeuses tondeuses= fileService.readInstructionsFile(fileName);

    }
}
