//
//  FileBase64.m
//  CC社交
//
//  Created by mac on 2018/10/9.
//

#import "FileBase64.h"

@implementation FileBase64
+ (NSString *)fileToBASE64:(NSString*)fileStr{
    NSString *suffix = [[fileStr pathExtension] lowercaseString];//后缀
    //    NSString *fileName = [fileStr lastPathComponent];
    NSString *encodedImageStr=[[NSString alloc]init];
    NSData *data = [NSData dataWithContentsOfFile:fileStr options:NSDataReadingUncached error:nil];
    NSString *dataStr = [data base64EncodedStringWithOptions:NSDataBase64EncodingEndLineWithCarriageReturn];
    NSString *dataType = [[NSString alloc]init];
    
    if ([suffix isEqualToString:@"mp4"]||[suffix isEqualToString:@"mpg4"]) {
        dataType = @"data:video/mp4;base64,";
    }else if ([suffix isEqualToString:@"3gp"]){
        dataType = @"data:video/3gp;base64,";
    }else if ([suffix isEqualToString:@"3gp"]){
        dataType = @"data:video/3gp;base64,";
    }else if ([suffix isEqualToString:@"avi"]){
        dataType = @"data:video/x-msvideo;base64";
    }else if ([suffix isEqualToString:@"mpeg"]){
        dataType = @"data:video/mpg;base64";
    }else if ([suffix isEqualToString:@"m3u"]){
        dataType = @"data:audio/x-mpegurl;base64";
    }else if ([suffix isEqualToString:@"m4a"]||[suffix isEqualToString:@"m4b"]||[suffix isEqualToString:@"m4p"]){
        dataType = @"data:audio/mp4a-latm;base64,";
    }else if ([suffix isEqualToString:@"mp2"]||[suffix isEqualToString:@"mp3"]){
        dataType = @"data:audio/x-mpeg;base64,";
    }else if ([suffix isEqualToString:@"wav"]){
        dataType = @"data:audio/x-wav;base64,";
    }else if ([suffix isEqualToString:@"ogg"]){
        dataType = @"data:audio/ogg;base64,";
    }else if ([suffix isEqualToString:@"rmvb"]){
        dataType = @"data:audio/x-pn-realaudio;base64,";
    }else if ([suffix isEqualToString:@"rmvb"]){
        dataType = @"data:audio/x-pn-realaudio;base64,";
    }else if ([suffix isEqualToString:@"wma"]){
        dataType = @"data:audio/x-ms-wma;base64,";
    }else if ([suffix isEqualToString:@"wmv"]){
        dataType = @"data:audio/x-ms-wmv;base64,";
    }else if ([suffix isEqualToString:@"c"]||[suffix isEqualToString:@"java"]||[suffix isEqualToString:@"conf"]||[suffix isEqualToString:@"h"]||[suffix isEqualToString:@"prop"]||[suffix isEqualToString:@"rc"]||[suffix isEqualToString:@"sh"]||[suffix isEqualToString:@"log"]||[suffix isEqualToString:@"txt"]||[suffix isEqualToString:@"xml"]){
        dataType = @"data:text/plain;base64,";
    }else if ([suffix isEqualToString:@"html"]||[suffix isEqualToString:@"htm"]){
        dataType = @"data:text/html;base64,";
    }else if ([suffix isEqualToString:@"css"]){
        dataType = @"data:text/css;base64,";
    }else if ([suffix isEqualToString:@"jpg"]||[suffix isEqualToString:@"jpeg"]){
        dataType = @"data:image/jpeg;base64,";
    }else if ([suffix isEqualToString:@"gif"]){
        dataType = @"data:image/gif;base64,";
    }else if ([suffix isEqualToString:@"png"]){
        dataType = @"data:image/png;base64,";
    }else{
        dataType = @"data:image/*;base64,";
    }
    
    
    
    encodedImageStr = [NSString stringWithFormat:@"%@%@",dataType,dataStr];
    
    return encodedImageStr;
    
}

- (void)encode:(CDVInvokedUrlCommand*)command{
    CDVPluginResult* pluginResult = nil;
    NSDictionary *echo = [command.arguments objectAtIndex:0];
    NSString *str = [FileBase64 fileToBASE64:[echo objectForKey:@"location"]];
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:str];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
