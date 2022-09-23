package com.mow.service;

import com.mow.model.Tondeuses;

public interface FileService {
    Tondeuses readInstructionsFile(String fileName);
    void writeToOutputFile(String filename, Tondeuses tondeuses);
}
