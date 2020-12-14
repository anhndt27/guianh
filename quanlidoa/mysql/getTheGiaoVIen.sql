SELECT tblnguoi.ID,tblhocsinh.maHocSinh,tblhoten.ho,tblhoten.tenDem,tblhoten.ten,
tbldiachi.soNha,tbldiachi.duong,tbldiachi.thon,tbldiachi.xa_Phuong,
tbldiachi.huyen_Quan,tbldiachi.tinh_ThanhPho,tblkhoi.tenKhoi,tbllop.tenLop,
tblhocsinh.hinhAnh,
tblnguoi.ngaySinh,tblnguoi.gioitinh,tblnguoi.email

FROM	tblhocsinh,tblnguoi,tblhoten,tbldiachi,tblkhoi,tbllop
WHERE	tblhocsinh.tblnguoiID = tblnguoi.ID
AND		tblhoten.ID = tblnguoi.tblHoTenID
AND		tbldiachi.ID = tblnguoi.tblDiaChiID
AND		tblhocsinh.tblLopID = tbllop.ID
AND		tbllop.tblKhoiID = tblkhoi.ID
AND 	tblhoten.ho LIKE '%%'
AND 	tblhoten.tenDem LIKE '%%'
AND 	tblhoten.ten LIKE '%%' 
