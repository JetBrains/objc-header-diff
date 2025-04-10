@interface Wheel
@end

@interface BasicCar
@property (readonly) Wheel wheel1
@property (readonly) Wheel wheel3
@property (readonly) Wheel wheel2
@property (readonly) Wheel wheel4
@end

@interface RaceCar: BasicCar
@end

@interface DeliveryTruck: BasicCar
@end