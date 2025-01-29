@interface Wheel
@end

@interface BasicCar
@property (readonly) Wheel wheel1
@property (readonly) Wheel wheel2
@property (readonly) Wheel wheel3
@end

@interface DeliveryTruck: BasicCar
@end

@interface Taxi: BasicCar
@end