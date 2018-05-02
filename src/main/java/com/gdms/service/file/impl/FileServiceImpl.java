package com.gdms.service.file.impl;
import com.gdms.service.file.FileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileServiceImpl implements FileService {

    private Logger log = Logger.getLogger(FileServiceImpl.class);

}
