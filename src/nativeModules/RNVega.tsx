import { NativeModules } from "react-native";

type RNVegaT = {
	sayHello: () => void;
};

const RNVega: RNVegaT = NativeModules.RNVega;

export default RNVega;
