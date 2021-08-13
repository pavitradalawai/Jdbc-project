package www.com.xworkz.dto;



	


	

		import java.io.Serializable;

		import www.com.xworkz.webenum.Genertype;
		import www.com.xworkz.webenum.StreamedInType;

		public class WebSeriesDTO implements Serializable {

			private int w_id;
			private String w_name;
			private int w_noOfEpisodes;
			private StreamedInType w_streamedIn;
			private Genertype w_gener;
			private int w_yestAgeIndaNodbohudu;

			public WebSeriesDTO() {
				super();
			}

			public WebSeriesDTO(String w_name, int w_id, int w_noOfEpisodes, StreamedInType w_streamedIn, Genertype w_gener,
					int w_yestAgeIndaNodbohudu) {
				super();
				this.w_id = w_id;
				this.w_name = w_name;
				this.w_noOfEpisodes = w_noOfEpisodes;
				this.w_streamedIn = w_streamedIn;
				this.w_gener = w_gener;
				this.w_yestAgeIndaNodbohudu = w_yestAgeIndaNodbohudu;
			}

			public WebSeriesDTO(String w_name, int w_noOfEpisodes, StreamedInType w_streamedIn, Genertype w_gener,
					int w_yestAgeIndaNodbohudu) {
				super();
				this.w_name = w_name;
				this.w_noOfEpisodes = w_noOfEpisodes;
				this.w_streamedIn = w_streamedIn;
				this.w_gener = w_gener;
				this.w_yestAgeIndaNodbohudu = w_yestAgeIndaNodbohudu;
			}

			@Override
			public String toString() {
				return "WebSeriesDTO [w_id=" + w_id + ", w_name=" + w_name + ", w_noOfEpisodes=" + w_noOfEpisodes
						+ ", w_streamedIn=" + w_streamedIn + ", w_gener=" + w_gener + ", w_yestAgeIndaNodbohudu="
						+ w_yestAgeIndaNodbohudu + "]";
			}

			public int getW_id() {
				return w_id;
			}

			public void setW_id(int w_id) {
				this.w_id = w_id;
			}

			public String getW_name() {
				return w_name;
			}

			public void setW_name(String w_name) {
				this.w_name = w_name;
			}

			public int getW_noOfEpisodes() {
				return w_noOfEpisodes;
			}

			public void setW_noOfEpisodes(int w_noOfEpisodes) {
				this.w_noOfEpisodes = w_noOfEpisodes;
			}

			public StreamedInType getW_streamedIn() {
				return w_streamedIn;
			}

			public void setW_streamedIn(StreamedInType w_streamedIn) {
				this.w_streamedIn = w_streamedIn;
			}

			public Genertype getW_gener() {
				return w_gener;
			}

			public void setW_gener(Genertype w_gener) {
				this.w_gener = w_gener;
			}

			public int getW_yestAgeIndaNodbohudu() {
				return w_yestAgeIndaNodbohudu;
			}

			public void setW_yestAgeIndaNodbohudu(int w_yestAgeIndaNodbohudu) {
				this.w_yestAgeIndaNodbohudu = w_yestAgeIndaNodbohudu;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + w_id;
				result = prime * result + ((w_name == null) ? 0 : w_name.hashCode());
				result = prime * result + ((w_streamedIn == null) ? 0 : w_streamedIn.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				WebSeriesDTO other = (WebSeriesDTO) obj;
				if (w_id != other.w_id)
					return false;
				if (w_name == null) {
					if (other.w_name != null)
						return false;
				} else if (!w_name.equals(other.w_name))
					return false;
				if (w_streamedIn != other.w_streamedIn)
					return false;
				return true;
			}

		}


