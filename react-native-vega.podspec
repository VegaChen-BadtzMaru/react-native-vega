require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name         = "react-native-vega"
  s.version      = package['version']
  s.summary      = "Vega Chen Library for React Native"

  s.authors      = { "Vega Chen" => "vegachen@xm.wonder.com" }
  s.homepage     = "https://github.com/VegaChen-BadtzMaru/react-native-vega"
  s.license      = package['license']
  s.platform     = :ios, "8.0"

  s.source       = { :git => "https://github.com/VegaChen-BadtzMaru/react-native-vega.git" }
  s.source_files  = "ios/RNVega/*.{h,m}"

  s.dependency 'React-Core'
end
