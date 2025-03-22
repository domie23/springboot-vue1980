const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoiaozhinengpeixun/",
            name: "gaoiaozhinengpeixun",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoiaozhinengpeixun/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校智能培训管理系统"
        } 
    }
}
export default base
