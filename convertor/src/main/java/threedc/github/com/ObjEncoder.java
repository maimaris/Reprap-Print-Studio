package threedc.github.com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ObjEncoder implements Encoder
{
	File filePath;

	public boolean encode(Model model, String output_path) throws IOException
	{
		filePath = new File(output_path);

		int triangle_count = model.triangle_count();
		Writer out = new FileWriter(output_path);

		out.write("# Exported to OBJ by 3dc\r\n");
		out.write("# github.com/bsutton/3dc\r\n");

		for (int i = 0; i < triangle_count; ++i)
		{
			WriteVerticies(out, model.get_triangle(i));
		}

		for (int i = 0; i < triangle_count; ++i)
		{
			WriteNormal(out, (model.get_triangle(i)).getNorm());
		}

		for (int i = 0; i < triangle_count; ++i)
		{
			WriteFace(out, i);
		}

		out.close();

		return true;
	}

	// Writes all the verticies for a triangle
	void WriteVerticies(Writer out, Triangle t) throws IOException
	{

		out.write("v ");
		out.write(t.getV1().x_ + " ");
		out.write(t.getV1().y_ + " ");
		out.write(t.getV1().z_ + "\r\n");
		out.write("v ");
		out.write(t.getV2().x_ + " ");
		out.write(t.getV2().y_ + " ");
		out.write(t.getV2().z_ + "\r\n");
		out.write("v ");
		out.write(t.getV3().x_ + " ");
		out.write(t.getV3().y_ + " ");
		out.write(t.getV3().z_ + "\r\n");
	}

	void WriteNormal(Writer out, Vertex n) throws IOException
	{

		out.write("n ");
		out.write(n.x_ + " ");
		out.write(n.y_ + " ");
		out.write(n.z_ + "\r\n");
	}

	void WriteFace(Writer out, int i) throws IOException
	{

		out.write("f ");
		out.write((i * 3) + 1 + "//" + i + 1 + " ");
		out.write((i * 3) + 2 + "//" + i + 1 + " ");
		out.write((i * 3) + 3 + "//" + i + 1 + "\r\n");
	}

	public String getFilePath() throws IOException
	{
		return filePath.getCanonicalPath();
	}
}