package com.mow;

import com.mow.model.Tondeuses;
import com.mow.service.FileService;
import com.mow.service.TondeuseService;
import com.mow.service.impl.FileServiceImpl;
import com.mow.service.impl.TondeuseServiceSable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final FileService fileService = new FileServiceImpl();

        final TondeuseService tondeuseService = new TondeuseServiceSable();

        String fileName = "src/main/resources/instructions.txt";

        Tondeuses tondeuses = fileService.readInstructionsFile(fileName);

        tondeuseService.deployerTondeuses(tondeuses);

        tondeuses.getListTondeuses().forEach(
            tondeuse -> System.out.println(tondeuse.toString())
        );

        

    }
}
