//
//  FileBase64.h
//  CC社交
//
//  Created by mac on 2018/10/9.
//

#import <Cordova/CDVPlugin.h>

NS_ASSUME_NONNULL_BEGIN

@interface FileBase64 : CDVPlugin
+ (NSString *)fileToBASE64:(NSString*)fileUrl;

- (void)encode:(CDVInvokedUrlCommand*)command;
@end

NS_ASSUME_NONNULL_END
