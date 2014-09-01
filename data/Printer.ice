// #include <sport_base.ice>
// com.java.demo.ice.sport
module com{
	module palm{
		module ice{
			module ice{
				// 对象，支撑继承
				class PIceStr{
					string lottery;
				};
				class PIceBean extends PIceStr{
					string name;
				};
				// Map
				dictionary<string,string> PIceMap;
				// 数组
				sequence<PIceBean> PIceBeanArray; 
				interface Printer{
					bool printPIceBean(PIceBean bean);
					bool printPIceMap(PIceMap map);
					bool printPIceBeanArray(PIceBeanArray array);
				};
			};
		};
	};
};