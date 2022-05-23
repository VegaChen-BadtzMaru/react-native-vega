#import "RNVega.h"
#import <React/RCTLog.h>

@implementation RNVega

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(sayHello) {
    RCTLogInfo(@"hello world!");
}

@end
