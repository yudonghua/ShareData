import java.io.*;

public class FileChange {
	public FileChange() {
	}
	public static String read(String path) {
		File file = new File(path);
		StringBuffer res = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				res.append(line + "\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res.toString();
	}

	public static boolean write(String cont, File dist) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dist));
			writer.write(cont);
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void getFileList(String strPath){
		File f=new File(strPath);
		if(f.isDirectory()){
            File[] fs=f.listFiles();
            for(int i=0;i<fs.length;i++){
                String fsPath=fs[i].getAbsolutePath();
                getFileList(fsPath);
            }
        }else if(f.isFile()){
            String fname=f.getAbsolutePath();
            if(fname.contains("constants.properties")){
				File src = new File(fname);
				String cont = TestFile.read(fname);
				cont = cont.replaceAll("127.0.0.1", "10.12.64.26");
				TestFile.write(cont,src );
			}
		}
	}

	public static void main(String[] args) {
		String strPath = "D:\\LocalSvn\\iSMS-Platform\\branches\\petrel\\V2.9\\南昌分公司\\IPM20180627073_南昌市中国银行大楼管理平台热备项目\\KF20180801_034\\CMS\\HikCMS";
		getFileList(strPath);
	}
}