import * as React from "react";
import { FC } from "react";
import {
	HostComponent,
	Platform,
	requireNativeComponent,
	ViewProps,
} from "react-native";

interface RNTMapEventI {
	nativeEvent: {
		region: {
			latitude: number;
			longitude: number;
			latitudeDelta: number;
			longitudeDelta: number;
		};
	};
}

interface RNTMapI extends ViewProps {
	zoomEnabled?: boolean;
	onRegionChange: (event: RNTMapEventI) => void;
}

const RNTMap: HostComponent<RNTMapI> = requireNativeComponent("RNTMap");

export interface IosMapViewI extends ViewProps {
	zoomEnabled?: boolean;
	region?: {
		latitude: number;
		longitude: number;
		latitudeDelta: number;
		longitudeDelta: number;
	};
	onRegionChange?: (nativeEvent: RNTMapEventI["nativeEvent"]) => void;
}

const IosMapView: FC<IosMapViewI> = (props) => {
	const newProps: IosMapViewI = {
		zoomEnabled: true,
		region: {
			latitude: 24.485408,
			longitude: 118.096435,
			latitudeDelta: 0.1,
			longitudeDelta: 0.1,
		},
		...props,
		style: props.style || { flex: 1 },
	};
	if (Platform.OS === "ios") {
		return (
			<RNTMap
				{...newProps}
				onRegionChange={(event) => {
					if (!props.onRegionChange) {
						return;
					}
					props.onRegionChange(event.nativeEvent);
				}}
			/>
		);
	}
	return null;
};

export default IosMapView;
