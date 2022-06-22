import { NativeModules, Platform } from "react-native";

interface DialogOptionsI {
	title?: string;
	message?: string;
	positive?: string;
	negative?: string;
}

export type RNVegaT = {
	sayHello: () => void;
	showDialog: (
		options: DialogOptionsI,
		positiveCB: () => void,
		negativeCB: () => void
	) => void;
	notificationInit: () => void;
	notificationSend: (title: string, context: string, channelId: number) => void;
	notificationCancel: (channelId: number) => void;
	notificationCancelAll: () => void;
};

const RNVegaModules = NativeModules.RNVega;

const VegaNotificationModule = NativeModules.VegaNotificationModule;

const RNVega: RNVegaT = {
	sayHello: () => {
		if (Platform.OS === "android") {
			RNVegaModules.sayHello();
		}
	},
	showDialog: (...params) => {
		if (Platform.OS === "android") {
			RNVegaModules.showDialog(...params);
		}
	},
	notificationInit: () => {
		if (Platform.OS === "android") {
			VegaNotificationModule.init();
		}
	},
	notificationSend: (...params) => {
		if (Platform.OS === "android") {
			VegaNotificationModule.send(...params);
		}
	},
	notificationCancel: (...params) => {
		if (Platform.OS === "android") {
			VegaNotificationModule.cancel(...params);
		}
	},
	notificationCancelAll: () => {
		if (Platform.OS === "android") {
			VegaNotificationModule.cancelAll();
		}
	},
};

export default RNVega;
