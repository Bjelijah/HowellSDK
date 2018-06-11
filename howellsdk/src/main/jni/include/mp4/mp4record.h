//
//  mp4record.h
//  RTSP_Player
//
//  Created by apple on 15/4/7.
//  Copyright (c) 2015年 thinker. All rights reserved.
//

#ifndef __RTSP_Player__mp4record__
#define __RTSP_Player__mp4record__

#include<stdint.h>
#include<string.h>

int initMp4Encoder(const char * filename,int width,int height);
int mp4VEncode(uint8_t * data ,int len);
int mp4AEncode(uint8_t * data ,int len);
void closeMp4Encoder();


#endif /* defined(__RTSP_Player__mp4record__) */
