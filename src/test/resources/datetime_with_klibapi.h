#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class SharedKotlinArray<T>, SharedKotlinEnum<E>, SharedKotlinEnumCompanion, SharedKotlinException, SharedKotlinIllegalArgumentException, SharedKotlinNothing, SharedKotlinRuntimeException, SharedKotlinThrowable, SharedKotlinx_datetimeAmPmMarker, SharedKotlinx_datetimeClockSystem, SharedKotlinx_datetimeDateBasedDateTimeUnitSerializer, SharedKotlinx_datetimeDatePeriod, SharedKotlinx_datetimeDatePeriodCompanion, SharedKotlinx_datetimeDatePeriodComponentSerializer, SharedKotlinx_datetimeDatePeriodIso8601Serializer, SharedKotlinx_datetimeDateTimeArithmeticException, SharedKotlinx_datetimeDateTimeComponents, SharedKotlinx_datetimeDateTimeComponentsCompanion, SharedKotlinx_datetimeDateTimeComponentsFormats, SharedKotlinx_datetimeDateTimePeriod, SharedKotlinx_datetimeDateTimePeriodCompanion, SharedKotlinx_datetimeDateTimePeriodComponentSerializer, SharedKotlinx_datetimeDateTimePeriodIso8601Serializer, SharedKotlinx_datetimeDateTimeUnit, SharedKotlinx_datetimeDateTimeUnitCompanion, SharedKotlinx_datetimeDateTimeUnitDateBased, SharedKotlinx_datetimeDateTimeUnitDateBasedCompanion, SharedKotlinx_datetimeDateTimeUnitDayBased, SharedKotlinx_datetimeDateTimeUnitDayBasedCompanion, SharedKotlinx_datetimeDateTimeUnitMonthBased, SharedKotlinx_datetimeDateTimeUnitMonthBasedCompanion, SharedKotlinx_datetimeDateTimeUnitSerializer, SharedKotlinx_datetimeDateTimeUnitTimeBased, SharedKotlinx_datetimeDateTimeUnitTimeBasedCompanion, SharedKotlinx_datetimeDayBasedDateTimeUnitSerializer, SharedKotlinx_datetimeDayOfWeek, SharedKotlinx_datetimeDayOfWeekNames, SharedKotlinx_datetimeDayOfWeekNamesCompanion, SharedKotlinx_datetimeDayOfWeekSerializer, SharedKotlinx_datetimeFixedOffsetTimeZone, SharedKotlinx_datetimeFixedOffsetTimeZoneCompanion, SharedKotlinx_datetimeFixedOffsetTimeZoneSerializer, SharedKotlinx_datetimeIllegalTimeZoneException, SharedKotlinx_datetimeInstant, SharedKotlinx_datetimeInstantCompanion, SharedKotlinx_datetimeInstantComponentSerializer, SharedKotlinx_datetimeInstantIso8601Serializer, SharedKotlinx_datetimeLocalDate, SharedKotlinx_datetimeLocalDateCompanion, SharedKotlinx_datetimeLocalDateComponentSerializer, SharedKotlinx_datetimeLocalDateFormats, SharedKotlinx_datetimeLocalDateIso8601Serializer, SharedKotlinx_datetimeLocalDateTime, SharedKotlinx_datetimeLocalDateTimeCompanion, SharedKotlinx_datetimeLocalDateTimeComponentSerializer, SharedKotlinx_datetimeLocalDateTimeFormats, SharedKotlinx_datetimeLocalDateTimeIso8601Serializer, SharedKotlinx_datetimeLocalTime, SharedKotlinx_datetimeLocalTimeCompanion, SharedKotlinx_datetimeLocalTimeComponentSerializer, SharedKotlinx_datetimeLocalTimeFormats, SharedKotlinx_datetimeLocalTimeIso8601Serializer, SharedKotlinx_datetimeMonth, SharedKotlinx_datetimeMonthBasedDateTimeUnitSerializer, SharedKotlinx_datetimeMonthNames, SharedKotlinx_datetimeMonthNamesCompanion, SharedKotlinx_datetimeMonthSerializer, SharedKotlinx_datetimePadding, SharedKotlinx_datetimeTimeBasedDateTimeUnitSerializer, SharedKotlinx_datetimeTimeZone, SharedKotlinx_datetimeTimeZoneCompanion, SharedKotlinx_datetimeTimeZoneSerializer, SharedKotlinx_datetimeUtcOffset, SharedKotlinx_datetimeUtcOffsetCompanion, SharedKotlinx_datetimeUtcOffsetFormats, SharedKotlinx_datetimeUtcOffsetSerializer, SharedKotlinx_serialization_coreAbstractPolymorphicSerializer<T>, SharedKotlinx_serialization_coreSerialKind, SharedKotlinx_serialization_coreSerializersModule;

@protocol SharedKotlinAnnotation, SharedKotlinAppendable, SharedKotlinComparable, SharedKotlinIterator, SharedKotlinKAnnotatedElement, SharedKotlinKClass, SharedKotlinKClassifier, SharedKotlinKDeclarationContainer, SharedKotlinx_datetimeClock, SharedKotlinx_datetimeDateTimeFormat, SharedKotlinx_datetimeDateTimeFormatBuilder, SharedKotlinx_datetimeDateTimeFormatBuilderWithDate, SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTime, SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTimeComponents, SharedKotlinx_datetimeDateTimeFormatBuilderWithTime, SharedKotlinx_datetimeDateTimeFormatBuilderWithUtcOffset, SharedKotlinx_serialization_coreCompositeDecoder, SharedKotlinx_serialization_coreCompositeEncoder, SharedKotlinx_serialization_coreDecoder, SharedKotlinx_serialization_coreDeserializationStrategy, SharedKotlinx_serialization_coreEncoder, SharedKotlinx_serialization_coreKSerializer, SharedKotlinx_serialization_coreSerialDescriptor, SharedKotlinx_serialization_coreSerializationStrategy, SharedKotlinx_serialization_coreSerializersModuleCollector, SharedPlatform;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface SharedBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface SharedBase (SharedBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface SharedMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface SharedMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorSharedKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface SharedNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface SharedByte : SharedNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface SharedUByte : SharedNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface SharedShort : SharedNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface SharedUShort : SharedNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface SharedInt : SharedNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface SharedUInt : SharedNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface SharedLong : SharedNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface SharedULong : SharedNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface SharedFloat : SharedNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface SharedDouble : SharedNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface SharedBoolean : SharedNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Greeting")))
@interface SharedGreeting : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)greet __attribute__((swift_name("greet()")));
@end

__attribute__((swift_name("Platform")))
@protocol SharedPlatform
@required
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IOSPlatform")))
@interface SharedIOSPlatform : SharedBase <SharedPlatform>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KlibApiKt")))
@interface SharedKlibApiKt : SharedBase
+ (id<SharedKotlinx_datetimeClock>)return_kotlinx_datetime_Clock __attribute__((swift_name("return_kotlinx_datetime_Clock()")));
+ (SharedKotlinx_datetimeClockSystem *)return_kotlinx_datetime_Clock_System __attribute__((swift_name("return_kotlinx_datetime_Clock_System()")));
+ (SharedKotlinx_datetimeDatePeriod *)return_kotlinx_datetime_DatePeriod __attribute__((swift_name("return_kotlinx_datetime_DatePeriod()")));
+ (SharedKotlinx_datetimeDateTimeArithmeticException *)return_kotlinx_datetime_DateTimeArithmeticException __attribute__((swift_name("return_kotlinx_datetime_DateTimeArithmeticException()")));
+ (SharedKotlinx_datetimeDateTimePeriod *)return_kotlinx_datetime_DateTimePeriod __attribute__((swift_name("return_kotlinx_datetime_DateTimePeriod()")));
+ (SharedKotlinx_datetimeDateTimeUnit *)return_kotlinx_datetime_DateTimeUnit __attribute__((swift_name("return_kotlinx_datetime_DateTimeUnit()")));
+ (SharedKotlinx_datetimeDateTimeUnitDateBased *)return_kotlinx_datetime_DateTimeUnit_DateBased __attribute__((swift_name("return_kotlinx_datetime_DateTimeUnit_DateBased()")));
+ (SharedKotlinx_datetimeDateTimeUnitDayBased *)return_kotlinx_datetime_DateTimeUnit_DayBased __attribute__((swift_name("return_kotlinx_datetime_DateTimeUnit_DayBased()")));
+ (SharedKotlinx_datetimeDateTimeUnitMonthBased *)return_kotlinx_datetime_DateTimeUnit_MonthBased __attribute__((swift_name("return_kotlinx_datetime_DateTimeUnit_MonthBased()")));
+ (SharedKotlinx_datetimeDateTimeUnitTimeBased *)return_kotlinx_datetime_DateTimeUnit_TimeBased __attribute__((swift_name("return_kotlinx_datetime_DateTimeUnit_TimeBased()")));
+ (SharedKotlinx_datetimeDayOfWeek *)return_kotlinx_datetime_DayOfWeek __attribute__((swift_name("return_kotlinx_datetime_DayOfWeek()")));
+ (SharedKotlinx_datetimeFixedOffsetTimeZone *)return_kotlinx_datetime_FixedOffsetTimeZone __attribute__((swift_name("return_kotlinx_datetime_FixedOffsetTimeZone()")));
+ (SharedKotlinx_datetimeIllegalTimeZoneException *)return_kotlinx_datetime_IllegalTimeZoneException __attribute__((swift_name("return_kotlinx_datetime_IllegalTimeZoneException()")));
+ (SharedKotlinx_datetimeInstant *)return_kotlinx_datetime_Instant __attribute__((swift_name("return_kotlinx_datetime_Instant()")));
+ (SharedKotlinx_datetimeLocalDate *)return_kotlinx_datetime_LocalDate __attribute__((swift_name("return_kotlinx_datetime_LocalDate()")));
+ (SharedKotlinx_datetimeLocalDateTime *)return_kotlinx_datetime_LocalDateTime __attribute__((swift_name("return_kotlinx_datetime_LocalDateTime()")));
+ (SharedKotlinx_datetimeLocalDateTimeFormats *)return_kotlinx_datetime_LocalDateTime_Formats __attribute__((swift_name("return_kotlinx_datetime_LocalDateTime_Formats()")));
+ (SharedKotlinx_datetimeLocalDateFormats *)return_kotlinx_datetime_LocalDate_Formats __attribute__((swift_name("return_kotlinx_datetime_LocalDate_Formats()")));
+ (SharedKotlinx_datetimeLocalTime *)return_kotlinx_datetime_LocalTime __attribute__((swift_name("return_kotlinx_datetime_LocalTime()")));
+ (SharedKotlinx_datetimeLocalTimeFormats *)return_kotlinx_datetime_LocalTime_Formats __attribute__((swift_name("return_kotlinx_datetime_LocalTime_Formats()")));
+ (SharedKotlinx_datetimeMonth *)return_kotlinx_datetime_Month __attribute__((swift_name("return_kotlinx_datetime_Month()")));
+ (SharedKotlinx_datetimeTimeZone *)return_kotlinx_datetime_TimeZone __attribute__((swift_name("return_kotlinx_datetime_TimeZone()")));
+ (SharedKotlinx_datetimeUtcOffset *)return_kotlinx_datetime_UtcOffset __attribute__((swift_name("return_kotlinx_datetime_UtcOffset()")));
+ (SharedKotlinx_datetimeUtcOffsetFormats *)return_kotlinx_datetime_UtcOffset_Formats __attribute__((swift_name("return_kotlinx_datetime_UtcOffset_Formats()")));
+ (SharedKotlinx_datetimeAmPmMarker *)return_kotlinx_datetime_format_AmPmMarker __attribute__((swift_name("return_kotlinx_datetime_format_AmPmMarker()")));
+ (SharedKotlinx_datetimeDateTimeComponents *)return_kotlinx_datetime_format_DateTimeComponents __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeComponents()")));
+ (SharedKotlinx_datetimeDateTimeComponentsFormats *)return_kotlinx_datetime_format_DateTimeComponents_Formats __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeComponents_Formats()")));
+ (id<SharedKotlinx_datetimeDateTimeFormat>)return_kotlinx_datetime_format_DateTimeFormat __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormat()")));
+ (id<SharedKotlinx_datetimeDateTimeFormatBuilder>)return_kotlinx_datetime_format_DateTimeFormatBuilder __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormatBuilder()")));
+ (id<SharedKotlinx_datetimeDateTimeFormatBuilderWithDate>)return_kotlinx_datetime_format_DateTimeFormatBuilder_WithDate __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormatBuilder_WithDate()")));
+ (id<SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTime>)return_kotlinx_datetime_format_DateTimeFormatBuilder_WithDateTime __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormatBuilder_WithDateTime()")));
+ (id<SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTimeComponents>)return_kotlinx_datetime_format_DateTimeFormatBuilder_WithDateTimeComponents __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormatBuilder_WithDateTimeComponents()")));
+ (id<SharedKotlinx_datetimeDateTimeFormatBuilderWithTime>)return_kotlinx_datetime_format_DateTimeFormatBuilder_WithTime __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormatBuilder_WithTime()")));
+ (id<SharedKotlinx_datetimeDateTimeFormatBuilderWithUtcOffset>)return_kotlinx_datetime_format_DateTimeFormatBuilder_WithUtcOffset __attribute__((swift_name("return_kotlinx_datetime_format_DateTimeFormatBuilder_WithUtcOffset()")));
+ (SharedKotlinx_datetimeDayOfWeekNames *)return_kotlinx_datetime_format_DayOfWeekNames __attribute__((swift_name("return_kotlinx_datetime_format_DayOfWeekNames()")));
+ (SharedKotlinx_datetimeMonthNames *)return_kotlinx_datetime_format_MonthNames __attribute__((swift_name("return_kotlinx_datetime_format_MonthNames()")));
+ (SharedKotlinx_datetimePadding *)return_kotlinx_datetime_format_Padding __attribute__((swift_name("return_kotlinx_datetime_format_Padding()")));
+ (SharedKotlinx_datetimeDateBasedDateTimeUnitSerializer *)return_kotlinx_datetime_serializers_DateBasedDateTimeUnitSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DateBasedDateTimeUnitSerializer()")));
+ (SharedKotlinx_datetimeDatePeriodComponentSerializer *)return_kotlinx_datetime_serializers_DatePeriodComponentSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DatePeriodComponentSerializer()")));
+ (SharedKotlinx_datetimeDatePeriodIso8601Serializer *)return_kotlinx_datetime_serializers_DatePeriodIso8601Serializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DatePeriodIso8601Serializer()")));
+ (SharedKotlinx_datetimeDateTimePeriodComponentSerializer *)return_kotlinx_datetime_serializers_DateTimePeriodComponentSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DateTimePeriodComponentSerializer()")));
+ (SharedKotlinx_datetimeDateTimePeriodIso8601Serializer *)return_kotlinx_datetime_serializers_DateTimePeriodIso8601Serializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DateTimePeriodIso8601Serializer()")));
+ (SharedKotlinx_datetimeDateTimeUnitSerializer *)return_kotlinx_datetime_serializers_DateTimeUnitSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DateTimeUnitSerializer()")));
+ (SharedKotlinx_datetimeDayBasedDateTimeUnitSerializer *)return_kotlinx_datetime_serializers_DayBasedDateTimeUnitSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DayBasedDateTimeUnitSerializer()")));
+ (SharedKotlinx_datetimeDayOfWeekSerializer *)return_kotlinx_datetime_serializers_DayOfWeekSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_DayOfWeekSerializer()")));
+ (SharedKotlinx_datetimeFixedOffsetTimeZoneSerializer *)return_kotlinx_datetime_serializers_FixedOffsetTimeZoneSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_FixedOffsetTimeZoneSerializer()")));
+ (SharedKotlinx_datetimeInstantComponentSerializer *)return_kotlinx_datetime_serializers_InstantComponentSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_InstantComponentSerializer()")));
+ (SharedKotlinx_datetimeInstantIso8601Serializer *)return_kotlinx_datetime_serializers_InstantIso8601Serializer __attribute__((swift_name("return_kotlinx_datetime_serializers_InstantIso8601Serializer()")));
+ (SharedKotlinx_datetimeLocalDateComponentSerializer *)return_kotlinx_datetime_serializers_LocalDateComponentSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_LocalDateComponentSerializer()")));
+ (SharedKotlinx_datetimeLocalDateIso8601Serializer *)return_kotlinx_datetime_serializers_LocalDateIso8601Serializer __attribute__((swift_name("return_kotlinx_datetime_serializers_LocalDateIso8601Serializer()")));
+ (SharedKotlinx_datetimeLocalDateTimeComponentSerializer *)return_kotlinx_datetime_serializers_LocalDateTimeComponentSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_LocalDateTimeComponentSerializer()")));
+ (SharedKotlinx_datetimeLocalDateTimeIso8601Serializer *)return_kotlinx_datetime_serializers_LocalDateTimeIso8601Serializer __attribute__((swift_name("return_kotlinx_datetime_serializers_LocalDateTimeIso8601Serializer()")));
+ (SharedKotlinx_datetimeLocalTimeComponentSerializer *)return_kotlinx_datetime_serializers_LocalTimeComponentSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_LocalTimeComponentSerializer()")));
+ (SharedKotlinx_datetimeLocalTimeIso8601Serializer *)return_kotlinx_datetime_serializers_LocalTimeIso8601Serializer __attribute__((swift_name("return_kotlinx_datetime_serializers_LocalTimeIso8601Serializer()")));
+ (SharedKotlinx_datetimeMonthBasedDateTimeUnitSerializer *)return_kotlinx_datetime_serializers_MonthBasedDateTimeUnitSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_MonthBasedDateTimeUnitSerializer()")));
+ (SharedKotlinx_datetimeMonthSerializer *)return_kotlinx_datetime_serializers_MonthSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_MonthSerializer()")));
+ (SharedKotlinx_datetimeTimeBasedDateTimeUnitSerializer *)return_kotlinx_datetime_serializers_TimeBasedDateTimeUnitSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_TimeBasedDateTimeUnitSerializer()")));
+ (SharedKotlinx_datetimeTimeZoneSerializer *)return_kotlinx_datetime_serializers_TimeZoneSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_TimeZoneSerializer()")));
+ (SharedKotlinx_datetimeUtcOffsetSerializer *)return_kotlinx_datetime_serializers_UtcOffsetSerializer __attribute__((swift_name("return_kotlinx_datetime_serializers_UtcOffsetSerializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform_iosKt")))
@interface SharedPlatform_iosKt : SharedBase
+ (id<SharedPlatform>)getPlatform __attribute__((swift_name("getPlatform()")));
@end

__attribute__((swift_name("Kotlinx_datetimeClock")))
@protocol SharedKotlinx_datetimeClock
@required
- (SharedKotlinx_datetimeInstant *)now __attribute__((swift_name("now()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeClockSystem")))
@interface SharedKotlinx_datetimeClockSystem : SharedBase <SharedKotlinx_datetimeClock>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)system __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeClockSystem *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeInstant *)now __attribute__((swift_name("now()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/DateTimePeriodIso8601Serializer))
*/
__attribute__((swift_name("Kotlinx_datetimeDateTimePeriod")))
@interface SharedKotlinx_datetimeDateTimePeriod : SharedBase
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimePeriodCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t days __attribute__((swift_name("days")));
@property (readonly) int32_t hours __attribute__((swift_name("hours")));
@property (readonly) int32_t minutes __attribute__((swift_name("minutes")));
@property (readonly) int32_t months __attribute__((swift_name("months")));
@property (readonly) int32_t nanoseconds __attribute__((swift_name("nanoseconds")));
@property (readonly) int32_t seconds __attribute__((swift_name("seconds")));
@property (readonly) int32_t years __attribute__((swift_name("years")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/DatePeriodIso8601Serializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDatePeriod")))
@interface SharedKotlinx_datetimeDatePeriod : SharedKotlinx_datetimeDateTimePeriod
- (instancetype)initWithYears:(int32_t)years months:(int32_t)months days:(int32_t)days __attribute__((swift_name("init(years:months:days:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDatePeriodCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) int32_t days __attribute__((swift_name("days")));
@property (readonly) int32_t hours __attribute__((swift_name("hours")));
@property (readonly) int32_t minutes __attribute__((swift_name("minutes")));
@property (readonly) int32_t nanoseconds __attribute__((swift_name("nanoseconds")));
@property (readonly) int32_t seconds __attribute__((swift_name("seconds")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface SharedKotlinThrowable : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (SharedKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface SharedKotlinException : SharedKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface SharedKotlinRuntimeException : SharedKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeArithmeticException")))
@interface SharedKotlinx_datetimeDateTimeArithmeticException : SharedKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString *)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable *)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString *)message cause:(SharedKotlinThrowable *)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/DateTimeUnitSerializer))
*/
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit")))
@interface SharedKotlinx_datetimeDateTimeUnit : SharedBase
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimeUnitCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (NSString *)formatToStringValue:(int32_t)value unit:(NSString *)unit __attribute__((swift_name("formatToString(value:unit:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (NSString *)formatToStringValue:(int64_t)value unit_:(NSString *)unit __attribute__((swift_name("formatToString(value:unit_:)")));
- (SharedKotlinx_datetimeDateTimeUnit *)timesScalar:(int32_t)scalar __attribute__((swift_name("times(scalar:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/DateBasedDateTimeUnitSerializer))
*/
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.DateBased")))
@interface SharedKotlinx_datetimeDateTimeUnitDateBased : SharedKotlinx_datetimeDateTimeUnit
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimeUnitDateBasedCompanion *companion __attribute__((swift_name("companion")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/DayBasedDateTimeUnitSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.DayBased")))
@interface SharedKotlinx_datetimeDateTimeUnitDayBased : SharedKotlinx_datetimeDateTimeUnitDateBased
- (instancetype)initWithDays:(int32_t)days __attribute__((swift_name("init(days:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimeUnitDayBasedCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (SharedKotlinx_datetimeDateTimeUnitDayBased *)timesScalar:(int32_t)scalar __attribute__((swift_name("times(scalar:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t days __attribute__((swift_name("days")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/MonthBasedDateTimeUnitSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.MonthBased")))
@interface SharedKotlinx_datetimeDateTimeUnitMonthBased : SharedKotlinx_datetimeDateTimeUnitDateBased
- (instancetype)initWithMonths:(int32_t)months __attribute__((swift_name("init(months:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimeUnitMonthBasedCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (SharedKotlinx_datetimeDateTimeUnitMonthBased *)timesScalar:(int32_t)scalar __attribute__((swift_name("times(scalar:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t months __attribute__((swift_name("months")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/TimeBasedDateTimeUnitSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.TimeBased")))
@interface SharedKotlinx_datetimeDateTimeUnitTimeBased : SharedKotlinx_datetimeDateTimeUnit
- (instancetype)initWithNanoseconds:(int64_t)nanoseconds __attribute__((swift_name("init(nanoseconds:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimeUnitTimeBasedCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (SharedKotlinx_datetimeDateTimeUnitTimeBased *)timesScalar:(int32_t)scalar __attribute__((swift_name("times(scalar:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t duration __attribute__((swift_name("duration")));
@property (readonly) int64_t nanoseconds __attribute__((swift_name("nanoseconds")));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol SharedKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface SharedKotlinEnum<E> : SharedBase <SharedKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDayOfWeek")))
@interface SharedKotlinx_datetimeDayOfWeek : SharedKotlinEnum<SharedKotlinx_datetimeDayOfWeek *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *monday __attribute__((swift_name("monday")));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *tuesday __attribute__((swift_name("tuesday")));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *wednesday __attribute__((swift_name("wednesday")));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *thursday __attribute__((swift_name("thursday")));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *friday __attribute__((swift_name("friday")));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *saturday __attribute__((swift_name("saturday")));
@property (class, readonly) SharedKotlinx_datetimeDayOfWeek *sunday __attribute__((swift_name("sunday")));
+ (SharedKotlinArray<SharedKotlinx_datetimeDayOfWeek *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedKotlinx_datetimeDayOfWeek *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/TimeZoneSerializer))
*/
__attribute__((swift_name("Kotlinx_datetimeTimeZone")))
@interface SharedKotlinx_datetimeTimeZone : SharedBase
@property (class, readonly, getter=companion) SharedKotlinx_datetimeTimeZoneCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (SharedKotlinx_datetimeInstant *)toInstant:(SharedKotlinx_datetimeLocalDateTime *)receiver __attribute__((swift_name("toInstant(_:)")));
- (SharedKotlinx_datetimeLocalDateTime *)toLocalDateTime:(SharedKotlinx_datetimeInstant *)receiver __attribute__((swift_name("toLocalDateTime(_:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/FixedOffsetTimeZoneSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeFixedOffsetTimeZone")))
@interface SharedKotlinx_datetimeFixedOffsetTimeZone : SharedKotlinx_datetimeTimeZone
- (instancetype)initWithOffset:(SharedKotlinx_datetimeUtcOffset *)offset __attribute__((swift_name("init(offset:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeFixedOffsetTimeZoneCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) SharedKotlinx_datetimeUtcOffset *offset __attribute__((swift_name("offset")));
@property (readonly) int32_t totalSeconds __attribute__((swift_name("totalSeconds"))) __attribute__((deprecated("Use offset.totalSeconds")));
@end

__attribute__((swift_name("KotlinIllegalArgumentException")))
@interface SharedKotlinIllegalArgumentException : SharedKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeIllegalTimeZoneException")))
@interface SharedKotlinx_datetimeIllegalTimeZoneException : SharedKotlinIllegalArgumentException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString *)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable *)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString *)message cause:(SharedKotlinThrowable *)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/InstantIso8601Serializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeInstant")))
@interface SharedKotlinx_datetimeInstant : SharedBase <SharedKotlinComparable>
@property (class, readonly, getter=companion) SharedKotlinx_datetimeInstantCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(SharedKotlinx_datetimeInstant *)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (SharedKotlinx_datetimeInstant *)minusDuration:(int64_t)duration __attribute__((swift_name("minus(duration:)")));
- (int64_t)minusOther:(SharedKotlinx_datetimeInstant *)other __attribute__((swift_name("minus(other:)")));
- (SharedKotlinx_datetimeInstant *)plusDuration:(int64_t)duration __attribute__((swift_name("plus(duration:)")));
- (int64_t)toEpochMilliseconds __attribute__((swift_name("toEpochMilliseconds()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t epochSeconds __attribute__((swift_name("epochSeconds")));
@property (readonly) int32_t nanosecondsOfSecond __attribute__((swift_name("nanosecondsOfSecond")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/LocalDateIso8601Serializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDate")))
@interface SharedKotlinx_datetimeLocalDate : SharedBase <SharedKotlinComparable>
- (instancetype)initWithYear:(int32_t)year monthNumber:(int32_t)monthNumber dayOfMonth:(int32_t)dayOfMonth __attribute__((swift_name("init(year:monthNumber:dayOfMonth:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithYear:(int32_t)year month:(SharedKotlinx_datetimeMonth *)month dayOfMonth:(int32_t)dayOfMonth __attribute__((swift_name("init(year:month:dayOfMonth:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeLocalDateCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(SharedKotlinx_datetimeLocalDate *)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (int32_t)toEpochDays __attribute__((swift_name("toEpochDays()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) SharedKotlinx_datetimeDayOfWeek *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) SharedKotlinx_datetimeMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t monthNumber __attribute__((swift_name("monthNumber")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/LocalDateTimeIso8601Serializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateTime")))
@interface SharedKotlinx_datetimeLocalDateTime : SharedBase <SharedKotlinComparable>
- (instancetype)initWithDate:(SharedKotlinx_datetimeLocalDate *)date time:(SharedKotlinx_datetimeLocalTime *)time __attribute__((swift_name("init(date:time:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithYear:(int32_t)year monthNumber:(int32_t)monthNumber dayOfMonth:(int32_t)dayOfMonth hour:(int32_t)hour minute:(int32_t)minute second:(int32_t)second nanosecond:(int32_t)nanosecond __attribute__((swift_name("init(year:monthNumber:dayOfMonth:hour:minute:second:nanosecond:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithYear:(int32_t)year month:(SharedKotlinx_datetimeMonth *)month dayOfMonth:(int32_t)dayOfMonth hour:(int32_t)hour minute:(int32_t)minute second:(int32_t)second nanosecond:(int32_t)nanosecond __attribute__((swift_name("init(year:month:dayOfMonth:hour:minute:second:nanosecond:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeLocalDateTimeCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(SharedKotlinx_datetimeLocalDateTime *)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedKotlinx_datetimeLocalDate *date __attribute__((swift_name("date")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) SharedKotlinx_datetimeDayOfWeek *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) int32_t hour __attribute__((swift_name("hour")));
@property (readonly) int32_t minute __attribute__((swift_name("minute")));
@property (readonly) SharedKotlinx_datetimeMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t monthNumber __attribute__((swift_name("monthNumber")));
@property (readonly) int32_t nanosecond __attribute__((swift_name("nanosecond")));
@property (readonly) int32_t second __attribute__((swift_name("second")));
@property (readonly) SharedKotlinx_datetimeLocalTime *time __attribute__((swift_name("time")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateTime.Formats")))
@interface SharedKotlinx_datetimeLocalDateTimeFormats : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)formats __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateTimeFormats *shared __attribute__((swift_name("shared")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO __attribute__((swift_name("ISO")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDate.Formats")))
@interface SharedKotlinx_datetimeLocalDateFormats : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)formats __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateFormats *shared __attribute__((swift_name("shared")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO __attribute__((swift_name("ISO")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO_BASIC __attribute__((swift_name("ISO_BASIC")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/LocalTimeIso8601Serializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalTime")))
@interface SharedKotlinx_datetimeLocalTime : SharedBase <SharedKotlinComparable>
- (instancetype)initWithHour:(int32_t)hour minute:(int32_t)minute second:(int32_t)second nanosecond:(int32_t)nanosecond __attribute__((swift_name("init(hour:minute:second:nanosecond:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeLocalTimeCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(SharedKotlinx_datetimeLocalTime *)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (int32_t)toMillisecondOfDay __attribute__((swift_name("toMillisecondOfDay()")));
- (int64_t)toNanosecondOfDay __attribute__((swift_name("toNanosecondOfDay()")));
- (int32_t)toSecondOfDay __attribute__((swift_name("toSecondOfDay()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t hour __attribute__((swift_name("hour")));
@property (readonly) int32_t minute __attribute__((swift_name("minute")));
@property (readonly) int32_t nanosecond __attribute__((swift_name("nanosecond")));
@property (readonly) int32_t second __attribute__((swift_name("second")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalTime.Formats")))
@interface SharedKotlinx_datetimeLocalTimeFormats : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)formats __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalTimeFormats *shared __attribute__((swift_name("shared")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO __attribute__((swift_name("ISO")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeMonth")))
@interface SharedKotlinx_datetimeMonth : SharedKotlinEnum<SharedKotlinx_datetimeMonth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedKotlinx_datetimeMonth *january __attribute__((swift_name("january")));
@property (class, readonly) SharedKotlinx_datetimeMonth *february __attribute__((swift_name("february")));
@property (class, readonly) SharedKotlinx_datetimeMonth *march __attribute__((swift_name("march")));
@property (class, readonly) SharedKotlinx_datetimeMonth *april __attribute__((swift_name("april")));
@property (class, readonly) SharedKotlinx_datetimeMonth *may __attribute__((swift_name("may")));
@property (class, readonly) SharedKotlinx_datetimeMonth *june __attribute__((swift_name("june")));
@property (class, readonly) SharedKotlinx_datetimeMonth *july __attribute__((swift_name("july")));
@property (class, readonly) SharedKotlinx_datetimeMonth *august __attribute__((swift_name("august")));
@property (class, readonly) SharedKotlinx_datetimeMonth *september __attribute__((swift_name("september")));
@property (class, readonly) SharedKotlinx_datetimeMonth *october __attribute__((swift_name("october")));
@property (class, readonly) SharedKotlinx_datetimeMonth *november __attribute__((swift_name("november")));
@property (class, readonly) SharedKotlinx_datetimeMonth *december __attribute__((swift_name("december")));
+ (SharedKotlinArray<SharedKotlinx_datetimeMonth *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedKotlinx_datetimeMonth *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/datetime/serializers/UtcOffsetSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeUtcOffset")))
@interface SharedKotlinx_datetimeUtcOffset : SharedBase
@property (class, readonly, getter=companion) SharedKotlinx_datetimeUtcOffsetCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t totalSeconds __attribute__((swift_name("totalSeconds")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeUtcOffset.Formats")))
@interface SharedKotlinx_datetimeUtcOffsetFormats : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)formats __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeUtcOffsetFormats *shared __attribute__((swift_name("shared")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> FOUR_DIGITS __attribute__((swift_name("FOUR_DIGITS")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO __attribute__((swift_name("ISO")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO_BASIC __attribute__((swift_name("ISO_BASIC")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeAmPmMarker")))
@interface SharedKotlinx_datetimeAmPmMarker : SharedKotlinEnum<SharedKotlinx_datetimeAmPmMarker *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedKotlinx_datetimeAmPmMarker *am __attribute__((swift_name("am")));
@property (class, readonly) SharedKotlinx_datetimeAmPmMarker *pm __attribute__((swift_name("pm")));
+ (SharedKotlinArray<SharedKotlinx_datetimeAmPmMarker *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedKotlinx_datetimeAmPmMarker *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeComponents")))
@interface SharedKotlinx_datetimeDateTimeComponents : SharedBase
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDateTimeComponentsCompanion *companion __attribute__((swift_name("companion")));
- (void)setDateLocalDate:(SharedKotlinx_datetimeLocalDate *)localDate __attribute__((swift_name("setDate(localDate:)")));
- (void)setDateTimeLocalDateTime:(SharedKotlinx_datetimeLocalDateTime *)localDateTime __attribute__((swift_name("setDateTime(localDateTime:)")));
- (void)setDateTimeOffsetInstant:(SharedKotlinx_datetimeInstant *)instant utcOffset:(SharedKotlinx_datetimeUtcOffset *)utcOffset __attribute__((swift_name("setDateTimeOffset(instant:utcOffset:)")));
- (void)setDateTimeOffsetLocalDateTime:(SharedKotlinx_datetimeLocalDateTime *)localDateTime utcOffset:(SharedKotlinx_datetimeUtcOffset *)utcOffset __attribute__((swift_name("setDateTimeOffset(localDateTime:utcOffset:)")));
- (void)setOffsetUtcOffset:(SharedKotlinx_datetimeUtcOffset *)utcOffset __attribute__((swift_name("setOffset(utcOffset:)")));
- (void)setTimeLocalTime:(SharedKotlinx_datetimeLocalTime *)localTime __attribute__((swift_name("setTime(localTime:)")));
- (SharedKotlinx_datetimeInstant *)toInstantUsingOffset __attribute__((swift_name("toInstantUsingOffset()")));
- (SharedKotlinx_datetimeLocalDate *)toLocalDate __attribute__((swift_name("toLocalDate()")));
- (SharedKotlinx_datetimeLocalDateTime *)toLocalDateTime __attribute__((swift_name("toLocalDateTime()")));
- (SharedKotlinx_datetimeLocalTime *)toLocalTime __attribute__((swift_name("toLocalTime()")));
- (SharedKotlinx_datetimeUtcOffset *)toUtcOffset __attribute__((swift_name("toUtcOffset()")));
@property SharedKotlinx_datetimeAmPmMarker * _Nullable amPm __attribute__((swift_name("amPm")));
@property SharedInt * _Nullable dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property SharedKotlinx_datetimeDayOfWeek * _Nullable dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property SharedInt * _Nullable dayOfYear __attribute__((swift_name("dayOfYear")));
@property SharedInt * _Nullable hour __attribute__((swift_name("hour")));
@property SharedInt * _Nullable hourOfAmPm __attribute__((swift_name("hourOfAmPm")));
@property SharedInt * _Nullable minute __attribute__((swift_name("minute")));
@property SharedKotlinx_datetimeMonth * _Nullable month __attribute__((swift_name("month")));
@property SharedInt * _Nullable monthNumber __attribute__((swift_name("monthNumber")));
@property SharedInt * _Nullable nanosecond __attribute__((swift_name("nanosecond")));
@property SharedInt * _Nullable offsetHours __attribute__((swift_name("offsetHours")));
@property SharedBoolean * _Nullable offsetIsNegative __attribute__((swift_name("offsetIsNegative")));
@property SharedInt * _Nullable offsetMinutesOfHour __attribute__((swift_name("offsetMinutesOfHour")));
@property SharedInt * _Nullable offsetSecondsOfMinute __attribute__((swift_name("offsetSecondsOfMinute")));
@property SharedInt * _Nullable second __attribute__((swift_name("second")));
@property NSString * _Nullable timeZoneId __attribute__((swift_name("timeZoneId")));
@property SharedInt * _Nullable year __attribute__((swift_name("year")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeComponents.Formats")))
@interface SharedKotlinx_datetimeDateTimeComponentsFormats : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)formats __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeComponentsFormats *shared __attribute__((swift_name("shared")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> ISO_DATE_TIME_OFFSET __attribute__((swift_name("ISO_DATE_TIME_OFFSET")));
@property (readonly) id<SharedKotlinx_datetimeDateTimeFormat> RFC_1123 __attribute__((swift_name("RFC_1123")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormat")))
@protocol SharedKotlinx_datetimeDateTimeFormat
@required
- (NSString *)formatValue:(id _Nullable)value __attribute__((swift_name("format(value:)")));
- (id<SharedKotlinAppendable>)formatToAppendable:(id<SharedKotlinAppendable>)appendable value:(id _Nullable)value __attribute__((swift_name("formatTo(appendable:value:)")));
- (id _Nullable)parseInput:(id)input __attribute__((swift_name("parse(input:)")));
- (id _Nullable)parseOrNullInput:(id)input __attribute__((swift_name("parseOrNull(input:)")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormatBuilder")))
@protocol SharedKotlinx_datetimeDateTimeFormatBuilder
@required
- (void)charsValue:(NSString *)value __attribute__((swift_name("chars(value:)")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormatBuilderWithDate")))
@protocol SharedKotlinx_datetimeDateTimeFormatBuilderWithDate <SharedKotlinx_datetimeDateTimeFormatBuilder>
@required
- (void)dateFormat:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("date(format:)")));
- (void)dayOfMonthPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("dayOfMonth(padding:)")));
- (void)dayOfWeekNames:(SharedKotlinx_datetimeDayOfWeekNames *)names __attribute__((swift_name("dayOfWeek(names:)")));
- (void)dayOfYearPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("dayOfYear(padding:)")));
- (void)monthNameNames:(SharedKotlinx_datetimeMonthNames *)names __attribute__((swift_name("monthName(names:)")));
- (void)monthNumberPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("monthNumber(padding:)")));
- (void)yearPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("year(padding:)")));
- (void)yearTwoDigitsBaseYear:(int32_t)baseYear __attribute__((swift_name("yearTwoDigits(baseYear:)")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormatBuilderWithTime")))
@protocol SharedKotlinx_datetimeDateTimeFormatBuilderWithTime <SharedKotlinx_datetimeDateTimeFormatBuilder>
@required
- (void)amPmHourPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("amPmHour(padding:)")));
- (void)amPmMarkerAm:(NSString *)am pm:(NSString *)pm __attribute__((swift_name("amPmMarker(am:pm:)")));
- (void)hourPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("hour(padding:)")));
- (void)minutePadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("minute(padding:)")));
- (void)secondPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("second(padding:)")));
- (void)secondFractionFixedLength:(int32_t)fixedLength __attribute__((swift_name("secondFraction(fixedLength:)")));
- (void)secondFractionMinLength:(int32_t)minLength maxLength:(int32_t)maxLength __attribute__((swift_name("secondFraction(minLength:maxLength:)")));
- (void)timeFormat:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("time(format:)")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormatBuilderWithDateTime")))
@protocol SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTime <SharedKotlinx_datetimeDateTimeFormatBuilderWithDate, SharedKotlinx_datetimeDateTimeFormatBuilderWithTime>
@required
- (void)dateTimeFormat:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("dateTime(format:)")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormatBuilderWithUtcOffset")))
@protocol SharedKotlinx_datetimeDateTimeFormatBuilderWithUtcOffset <SharedKotlinx_datetimeDateTimeFormatBuilder>
@required
- (void)offsetFormat:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("offset(format:)")));
- (void)offsetHoursPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("offsetHours(padding:)")));
- (void)offsetMinutesOfHourPadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("offsetMinutesOfHour(padding:)")));
- (void)offsetSecondsOfMinutePadding:(SharedKotlinx_datetimePadding *)padding __attribute__((swift_name("offsetSecondsOfMinute(padding:)")));
@end

__attribute__((swift_name("Kotlinx_datetimeDateTimeFormatBuilderWithDateTimeComponents")))
@protocol SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTimeComponents <SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTime, SharedKotlinx_datetimeDateTimeFormatBuilderWithUtcOffset>
@required
- (void)dateTimeComponentsFormat:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("dateTimeComponents(format:)")));
- (void)timeZoneId __attribute__((swift_name("timeZoneId()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDayOfWeekNames")))
@interface SharedKotlinx_datetimeDayOfWeekNames : SharedBase
- (instancetype)initWithNames:(NSArray<NSString *> *)names __attribute__((swift_name("init(names:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMonday:(NSString *)monday tuesday:(NSString *)tuesday wednesday:(NSString *)wednesday thursday:(NSString *)thursday friday:(NSString *)friday saturday:(NSString *)saturday sunday:(NSString *)sunday __attribute__((swift_name("init(monday:tuesday:wednesday:thursday:friday:saturday:sunday:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeDayOfWeekNamesCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<NSString *> *names __attribute__((swift_name("names")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeMonthNames")))
@interface SharedKotlinx_datetimeMonthNames : SharedBase
- (instancetype)initWithNames:(NSArray<NSString *> *)names __attribute__((swift_name("init(names:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithJanuary:(NSString *)january february:(NSString *)february march:(NSString *)march april:(NSString *)april may:(NSString *)may june:(NSString *)june july:(NSString *)july august:(NSString *)august september:(NSString *)september october:(NSString *)october november:(NSString *)november december:(NSString *)december __attribute__((swift_name("init(january:february:march:april:may:june:july:august:september:october:november:december:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinx_datetimeMonthNamesCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<NSString *> *names __attribute__((swift_name("names")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimePadding")))
@interface SharedKotlinx_datetimePadding : SharedKotlinEnum<SharedKotlinx_datetimePadding *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedKotlinx_datetimePadding *none __attribute__((swift_name("none")));
@property (class, readonly) SharedKotlinx_datetimePadding *zero __attribute__((swift_name("zero")));
@property (class, readonly) SharedKotlinx_datetimePadding *space __attribute__((swift_name("space")));
+ (SharedKotlinArray<SharedKotlinx_datetimePadding *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedKotlinx_datetimePadding *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol SharedKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol SharedKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol SharedKotlinx_serialization_coreKSerializer <SharedKotlinx_serialization_coreSerializationStrategy, SharedKotlinx_serialization_coreDeserializationStrategy>
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreAbstractPolymorphicSerializer")))
@interface SharedKotlinx_serialization_coreAbstractPolymorphicSerializer<T> : SharedBase <SharedKotlinx_serialization_coreKSerializer>
- (T)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));

/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable)findPolymorphicSerializerOrNullDecoder:(id<SharedKotlinx_serialization_coreCompositeDecoder>)decoder klassName:(NSString * _Nullable)klassName __attribute__((swift_name("findPolymorphicSerializerOrNull(decoder:klassName:)")));

/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable)findPolymorphicSerializerOrNullEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(T)value __attribute__((swift_name("findPolymorphicSerializerOrNull(encoder:value:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(T)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinKClass> baseClass __attribute__((swift_name("baseClass")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateBasedDateTimeUnitSerializer")))
@interface SharedKotlinx_datetimeDateBasedDateTimeUnitSerializer : SharedKotlinx_serialization_coreAbstractPolymorphicSerializer<SharedKotlinx_datetimeDateTimeUnitDateBased *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateBasedDateTimeUnitSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateBasedDateTimeUnitSerializer *shared __attribute__((swift_name("shared")));

/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable)findPolymorphicSerializerOrNullDecoder:(id<SharedKotlinx_serialization_coreCompositeDecoder>)decoder klassName:(NSString * _Nullable)klassName __attribute__((swift_name("findPolymorphicSerializerOrNull(decoder:klassName:)")));

/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable)findPolymorphicSerializerOrNullEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimeUnitDateBased *)value __attribute__((swift_name("findPolymorphicSerializerOrNull(encoder:value:)")));
@property (readonly) id<SharedKotlinKClass> baseClass __attribute__((swift_name("baseClass")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDatePeriodComponentSerializer")))
@interface SharedKotlinx_datetimeDatePeriodComponentSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)datePeriodComponentSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDatePeriodComponentSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDatePeriod *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDatePeriod *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDatePeriodIso8601Serializer")))
@interface SharedKotlinx_datetimeDatePeriodIso8601Serializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)datePeriodIso8601Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDatePeriodIso8601Serializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDatePeriod *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDatePeriod *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimePeriodComponentSerializer")))
@interface SharedKotlinx_datetimeDateTimePeriodComponentSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateTimePeriodComponentSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimePeriodComponentSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDateTimePeriod *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimePeriod *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimePeriodIso8601Serializer")))
@interface SharedKotlinx_datetimeDateTimePeriodIso8601Serializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateTimePeriodIso8601Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimePeriodIso8601Serializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDateTimePeriod *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimePeriod *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnitSerializer")))
@interface SharedKotlinx_datetimeDateTimeUnitSerializer : SharedKotlinx_serialization_coreAbstractPolymorphicSerializer<SharedKotlinx_datetimeDateTimeUnit *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dateTimeUnitSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeUnitSerializer *shared __attribute__((swift_name("shared")));

/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable)findPolymorphicSerializerOrNullDecoder:(id<SharedKotlinx_serialization_coreCompositeDecoder>)decoder klassName:(NSString * _Nullable)klassName __attribute__((swift_name("findPolymorphicSerializerOrNull(decoder:klassName:)")));

/**
 * @note annotations
 *   kotlinx.serialization.InternalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable)findPolymorphicSerializerOrNullEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimeUnit *)value __attribute__((swift_name("findPolymorphicSerializerOrNull(encoder:value:)")));
@property (readonly) id<SharedKotlinKClass> baseClass __attribute__((swift_name("baseClass")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDayBasedDateTimeUnitSerializer")))
@interface SharedKotlinx_datetimeDayBasedDateTimeUnitSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dayBasedDateTimeUnitSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDayBasedDateTimeUnitSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDateTimeUnitDayBased *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimeUnitDayBased *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDayOfWeekSerializer")))
@interface SharedKotlinx_datetimeDayOfWeekSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)dayOfWeekSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDayOfWeekSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDayOfWeek *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDayOfWeek *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeFixedOffsetTimeZoneSerializer")))
@interface SharedKotlinx_datetimeFixedOffsetTimeZoneSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)fixedOffsetTimeZoneSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeFixedOffsetTimeZoneSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeFixedOffsetTimeZone *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeFixedOffsetTimeZone *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeInstantComponentSerializer")))
@interface SharedKotlinx_datetimeInstantComponentSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)instantComponentSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeInstantComponentSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeInstant *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeInstant *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeInstantIso8601Serializer")))
@interface SharedKotlinx_datetimeInstantIso8601Serializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)instantIso8601Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeInstantIso8601Serializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeInstant *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeInstant *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateComponentSerializer")))
@interface SharedKotlinx_datetimeLocalDateComponentSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)localDateComponentSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateComponentSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeLocalDate *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeLocalDate *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateIso8601Serializer")))
@interface SharedKotlinx_datetimeLocalDateIso8601Serializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)localDateIso8601Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateIso8601Serializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeLocalDate *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeLocalDate *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateTimeComponentSerializer")))
@interface SharedKotlinx_datetimeLocalDateTimeComponentSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)localDateTimeComponentSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateTimeComponentSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeLocalDateTime *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeLocalDateTime *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateTimeIso8601Serializer")))
@interface SharedKotlinx_datetimeLocalDateTimeIso8601Serializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)localDateTimeIso8601Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateTimeIso8601Serializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeLocalDateTime *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeLocalDateTime *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalTimeComponentSerializer")))
@interface SharedKotlinx_datetimeLocalTimeComponentSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)localTimeComponentSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalTimeComponentSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeLocalTime *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeLocalTime *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalTimeIso8601Serializer")))
@interface SharedKotlinx_datetimeLocalTimeIso8601Serializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)localTimeIso8601Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalTimeIso8601Serializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeLocalTime *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeLocalTime *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeMonthBasedDateTimeUnitSerializer")))
@interface SharedKotlinx_datetimeMonthBasedDateTimeUnitSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)monthBasedDateTimeUnitSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeMonthBasedDateTimeUnitSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDateTimeUnitMonthBased *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimeUnitMonthBased *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeMonthSerializer")))
@interface SharedKotlinx_datetimeMonthSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)monthSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeMonthSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeMonth *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeMonth *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeTimeBasedDateTimeUnitSerializer")))
@interface SharedKotlinx_datetimeTimeBasedDateTimeUnitSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)timeBasedDateTimeUnitSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeTimeBasedDateTimeUnitSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDateTimeUnitTimeBased *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeDateTimeUnitTimeBased *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeTimeZoneSerializer")))
@interface SharedKotlinx_datetimeTimeZoneSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)timeZoneSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeTimeZoneSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeTimeZone *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeTimeZone *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeUtcOffsetSerializer")))
@interface SharedKotlinx_datetimeUtcOffsetSerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)utcOffsetSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeUtcOffsetSerializer *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeUtcOffset *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedKotlinx_datetimeUtcOffset *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimePeriod.Companion")))
@interface SharedKotlinx_datetimeDateTimePeriodCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimePeriodCompanion *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDateTimePeriod *)parseText:(NSString *)text __attribute__((swift_name("parse(text:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDatePeriod.Companion")))
@interface SharedKotlinx_datetimeDatePeriodCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDatePeriodCompanion *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeDatePeriod *)parseText:(NSString *)text __attribute__((swift_name("parse(text:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface SharedKotlinArray<T> : SharedBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(SharedInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<SharedKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.Companion")))
@interface SharedKotlinx_datetimeDateTimeUnitCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeUnitCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitMonthBased *CENTURY __attribute__((swift_name("CENTURY")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitDayBased *DAY __attribute__((swift_name("DAY")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitTimeBased *HOUR __attribute__((swift_name("HOUR")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitTimeBased *MICROSECOND __attribute__((swift_name("MICROSECOND")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitTimeBased *MILLISECOND __attribute__((swift_name("MILLISECOND")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitTimeBased *MINUTE __attribute__((swift_name("MINUTE")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitMonthBased *MONTH __attribute__((swift_name("MONTH")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitTimeBased *NANOSECOND __attribute__((swift_name("NANOSECOND")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitMonthBased *QUARTER __attribute__((swift_name("QUARTER")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitTimeBased *SECOND __attribute__((swift_name("SECOND")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitDayBased *WEEK __attribute__((swift_name("WEEK")));
@property (readonly) SharedKotlinx_datetimeDateTimeUnitMonthBased *YEAR __attribute__((swift_name("YEAR")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.DateBasedCompanion")))
@interface SharedKotlinx_datetimeDateTimeUnitDateBasedCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeUnitDateBasedCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.DayBasedCompanion")))
@interface SharedKotlinx_datetimeDateTimeUnitDayBasedCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeUnitDayBasedCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.MonthBasedCompanion")))
@interface SharedKotlinx_datetimeDateTimeUnitMonthBasedCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeUnitMonthBasedCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeUnit.TimeBasedCompanion")))
@interface SharedKotlinx_datetimeDateTimeUnitTimeBasedCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeUnitTimeBasedCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface SharedKotlinEnumCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeTimeZone.Companion")))
@interface SharedKotlinx_datetimeTimeZoneCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeTimeZoneCompanion *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeTimeZone *)currentSystemDefault __attribute__((swift_name("currentSystemDefault()")));
- (SharedKotlinx_datetimeTimeZone *)ofZoneId:(NSString *)zoneId __attribute__((swift_name("of(zoneId:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@property (readonly) SharedKotlinx_datetimeFixedOffsetTimeZone *UTC __attribute__((swift_name("UTC")));
@property (readonly) NSSet<NSString *> *availableZoneIds __attribute__((swift_name("availableZoneIds")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeFixedOffsetTimeZone.Companion")))
@interface SharedKotlinx_datetimeFixedOffsetTimeZoneCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeFixedOffsetTimeZoneCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeInstant.Companion")))
@interface SharedKotlinx_datetimeInstantCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeInstantCompanion *shared __attribute__((swift_name("shared")));
- (SharedKotlinx_datetimeInstant *)fromEpochMillisecondsEpochMilliseconds:(int64_t)epochMilliseconds __attribute__((swift_name("fromEpochMilliseconds(epochMilliseconds:)")));
- (SharedKotlinx_datetimeInstant *)fromEpochSecondsEpochSeconds:(int64_t)epochSeconds nanosecondAdjustment:(int32_t)nanosecondAdjustment __attribute__((swift_name("fromEpochSeconds(epochSeconds:nanosecondAdjustment:)")));
- (SharedKotlinx_datetimeInstant *)fromEpochSecondsEpochSeconds:(int64_t)epochSeconds nanosecondAdjustment_:(int64_t)nanosecondAdjustment __attribute__((swift_name("fromEpochSeconds(epochSeconds:nanosecondAdjustment_:)")));
- (SharedKotlinx_datetimeInstant *)now __attribute__((swift_name("now()"))) __attribute__((unavailable("Use Clock.System.now() instead")));
- (SharedKotlinx_datetimeInstant *)parseInput:(id)input format:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("parse(input:format:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@property (readonly) SharedKotlinx_datetimeInstant *DISTANT_FUTURE __attribute__((swift_name("DISTANT_FUTURE")));
@property (readonly) SharedKotlinx_datetimeInstant *DISTANT_PAST __attribute__((swift_name("DISTANT_PAST")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDate.Companion")))
@interface SharedKotlinx_datetimeLocalDateCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_datetimeDateTimeFormat>)FormatBlock:(void (^)(id<SharedKotlinx_datetimeDateTimeFormatBuilderWithDate>))block __attribute__((swift_name("Format(block:)")));
- (SharedKotlinx_datetimeLocalDate *)fromEpochDaysEpochDays:(int32_t)epochDays __attribute__((swift_name("fromEpochDays(epochDays:)")));
- (SharedKotlinx_datetimeLocalDate *)parseInput:(id)input format:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("parse(input:format:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalDateTime.Companion")))
@interface SharedKotlinx_datetimeLocalDateTimeCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalDateTimeCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_datetimeDateTimeFormat>)FormatBuilder:(void (^)(id<SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTime>))builder __attribute__((swift_name("Format(builder:)")));
- (SharedKotlinx_datetimeLocalDateTime *)parseInput:(id)input format:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("parse(input:format:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeLocalTime.Companion")))
@interface SharedKotlinx_datetimeLocalTimeCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeLocalTimeCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_datetimeDateTimeFormat>)FormatBuilder:(void (^)(id<SharedKotlinx_datetimeDateTimeFormatBuilderWithTime>))builder __attribute__((swift_name("Format(builder:)")));
- (SharedKotlinx_datetimeLocalTime *)fromMillisecondOfDayMillisecondOfDay:(int32_t)millisecondOfDay __attribute__((swift_name("fromMillisecondOfDay(millisecondOfDay:)")));
- (SharedKotlinx_datetimeLocalTime *)fromNanosecondOfDayNanosecondOfDay:(int64_t)nanosecondOfDay __attribute__((swift_name("fromNanosecondOfDay(nanosecondOfDay:)")));
- (SharedKotlinx_datetimeLocalTime *)fromSecondOfDaySecondOfDay:(int32_t)secondOfDay __attribute__((swift_name("fromSecondOfDay(secondOfDay:)")));
- (SharedKotlinx_datetimeLocalTime *)parseInput:(id)input format:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("parse(input:format:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeUtcOffset.Companion")))
@interface SharedKotlinx_datetimeUtcOffsetCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeUtcOffsetCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_datetimeDateTimeFormat>)FormatBlock:(void (^)(id<SharedKotlinx_datetimeDateTimeFormatBuilderWithUtcOffset>))block __attribute__((swift_name("Format(block:)")));
- (SharedKotlinx_datetimeUtcOffset *)parseInput:(id)input format:(id<SharedKotlinx_datetimeDateTimeFormat>)format __attribute__((swift_name("parse(input:format:)")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@property (readonly) SharedKotlinx_datetimeUtcOffset *ZERO __attribute__((swift_name("ZERO")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDateTimeComponents.Companion")))
@interface SharedKotlinx_datetimeDateTimeComponentsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDateTimeComponentsCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_datetimeDateTimeFormat>)FormatBlock:(void (^)(id<SharedKotlinx_datetimeDateTimeFormatBuilderWithDateTimeComponents>))block __attribute__((swift_name("Format(block:)")));
@end

__attribute__((swift_name("KotlinAppendable")))
@protocol SharedKotlinAppendable
@required
- (id<SharedKotlinAppendable>)appendValue:(unichar)value __attribute__((swift_name("append(value:)")));
- (id<SharedKotlinAppendable>)appendValue_:(id _Nullable)value __attribute__((swift_name("append(value_:)")));
- (id<SharedKotlinAppendable>)appendValue:(id _Nullable)value startIndex:(int32_t)startIndex endIndex:(int32_t)endIndex __attribute__((swift_name("append(value:startIndex:endIndex:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeDayOfWeekNames.Companion")))
@interface SharedKotlinx_datetimeDayOfWeekNamesCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeDayOfWeekNamesCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) SharedKotlinx_datetimeDayOfWeekNames *ENGLISH_ABBREVIATED __attribute__((swift_name("ENGLISH_ABBREVIATED")));
@property (readonly) SharedKotlinx_datetimeDayOfWeekNames *ENGLISH_FULL __attribute__((swift_name("ENGLISH_FULL")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_datetimeMonthNames.Companion")))
@interface SharedKotlinx_datetimeMonthNamesCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinx_datetimeMonthNamesCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) SharedKotlinx_datetimeMonthNames *ENGLISH_ABBREVIATED __attribute__((swift_name("ENGLISH_ABBREVIATED")));
@property (readonly) SharedKotlinx_datetimeMonthNames *ENGLISH_FULL __attribute__((swift_name("ENGLISH_FULL")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol SharedKotlinx_serialization_coreEncoder
@required
- (id<SharedKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<SharedKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<SharedKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol SharedKotlinx_serialization_coreSerialDescriptor
@required

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSArray<id<SharedKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSArray<id<SharedKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) SharedKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol SharedKotlinx_serialization_coreDecoder
@required
- (id<SharedKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<SharedKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (SharedKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol SharedKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<SharedKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol SharedKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol SharedKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol SharedKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol SharedKotlinKClass <SharedKotlinKDeclarationContainer, SharedKotlinKAnnotatedElement, SharedKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol SharedKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol SharedKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<SharedKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface SharedKotlinx_serialization_coreSerializersModule : SharedBase

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<SharedKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<SharedKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<SharedKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<SharedKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<SharedKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol SharedKotlinAnnotation
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface SharedKotlinx_serialization_coreSerialKind : SharedBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface SharedKotlinNothing : SharedBase
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol SharedKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<SharedKotlinKClass>)kClass provider:(id<SharedKotlinx_serialization_coreKSerializer> (^)(NSArray<id<SharedKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<SharedKotlinKClass>)kClass serializer:(id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<SharedKotlinKClass>)baseClass actualClass:(id<SharedKotlinKClass>)actualClass actualSerializer:(id<SharedKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<SharedKotlinKClass>)baseClass defaultDeserializerProvider:(id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<SharedKotlinKClass>)baseClass defaultDeserializerProvider:(id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<SharedKotlinKClass>)baseClass defaultSerializerProvider:(id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
